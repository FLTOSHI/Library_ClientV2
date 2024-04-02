package edu.fltoshi.library_clientv2.service;

import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import edu.fltoshi.library_clientv2.entity.BookEntity;
import edu.fltoshi.library_clientv2.response.BaseResponse;
import edu.fltoshi.library_clientv2.response.DataResponse;
import edu.fltoshi.library_clientv2.response.ListResponse;

import java.lang.reflect.Type;
import java.util.Comparator;

public class BookService {
    @Getter
    private ObservableList<BookEntity> data = FXCollections.observableArrayList();
    private final HTTPService http = new HTTPService();
    JSONService service = new JSONService();
    ClientProperties prop = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<BookEntity>>() {
    }.getType();
    private Type listType = new TypeToken<ListResponse<BookEntity>>() {
    }.getType();

    public void getAll() {
        ListResponse<BookEntity> data = new ListResponse<>();
        data = service.getObject(http.get(prop.getAllBook()), listType);
        if(data.isSuccess()) {
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
    }

    public void add(BookEntity data) {
        String temp = http.post(prop.getSaveBook(), service.getJson(data));
        DataResponse<BookEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()) {
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void update(BookEntity before, BookEntity after) {
        System.out.println(after);
        String temp = http.put(prop.getUpdateBook(), service.getJson(after));
        DataResponse<BookEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()) {
            this.data.remove(before);
            this.data.add(after);
            sort();
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    private void sort(){
        data.sort(Comparator.comparing(BookEntity::getTitle));
    }

    public void delete(BookEntity data) {
        String temp = http.delete(prop.getDeleteBook(), data.getId());
        BaseResponse response = service.getObject(temp, BaseResponse.class);
        if (response.isSuccess()) {
            this.data.remove(data);
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void findById(BookEntity data) {
        String temp = http.get(prop.getFindByIdBook() + data.getId());
        DataResponse<BookEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()) {
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

}
