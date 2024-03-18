package prs.fltoshi.library_clientv2.service;

import prs.fltoshi.library_clientv2.entity.BookEntity;
import prs.fltoshi.library_clientv2.response.BaseResponse;
import prs.fltoshi.library_clientv2.response.DataResponse;
import prs.fltoshi.library_clientv2.response.ListResponse;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.lang.reflect.Type;
public class BookService {
    // для хранения всех авторов
    @Getter
    private ObservableList<BookEntity> data = FXCollections.observableArrayList();
    private final HTTPService http = new HTTPService();
    JSONService service = new JSONService();
    ClientProperties properties = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<BookEntity>>(){}.getType();
    private Type listType = new TypeToken<DataResponse<BookEntity>>(){}.getType();

    public void getAll() {
        ListResponse<BookEntity> data = new ListResponse<>();
        data = service.getObject(http.get(properties.allBook), listType);
        if (data.getSuccess()) {
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
    }

    public void add(BookEntity data) {
        String temp = http.post(properties.saveBook, service.getJson(data));
        DataResponse<BookEntity> response = service.getObject(temp, dataType);
        if (response.getSuccess()) {
            this.data.remove(data);
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void delete(BookEntity data){
        String temp = http.delete(properties.deleteBook, data.getId());
        DataResponse<BookEntity> response = service.getObject(temp, BaseResponse.class);
        if (response.getSuccess()) {
            this.data.remove(data);
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void findById(BookEntity data) {
        String temp = http.get(properties.findByIdBook) + data.getId();
        DataResponse<BookEntity> response = service.getObject(temp, dataType);
        if (response.getSuccess()) {
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }
}
