package edu.fltoshi.library_clientv2.service;

import edu.fltoshi.library_clientv2.entity.AuthorEntity;
import edu.fltoshi.library_clientv2.response.BaseResponse;
import edu.fltoshi.library_clientv2.response.DataResponse;
import edu.fltoshi.library_clientv2.response.ListResponse;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.lang.reflect.Type;
public class AuthorService {
    @Getter
    private ObservableList<AuthorEntity> data = FXCollections.observableArrayList();
    private final HTTPService http = new HTTPService();
    JSONService service = new JSONService();
    ClientProperties properties = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<AuthorEntity>>() {
    }.getType();
    private Type listType = new TypeToken<ListResponse<AuthorEntity>>() {
    }.getType();

    public void getAll() {
        ListResponse<AuthorEntity> data = new ListResponse<>();
        data = service.getObject(http.get(properties.getAllAuthor()), listType);
        if (data.isSuccess()) {
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
    }

    public void add(AuthorEntity data) {
        String temp = http.post(properties.getSaveAuthor(), service.getJson(data));
        DataResponse<AuthorEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()) {
            this.data.remove(data);
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void delete(AuthorEntity data) {
        String temp = http.delete(properties.getDeleteAuthor(), data.getId());
        DataResponse<AuthorEntity> response = service.getObject(temp, BaseResponse.class);
        if (response.isSuccess()) {
            this.data.remove(data);
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void findById(AuthorEntity data) {
        String temp = http.get(properties.getFindByIdAuthor()) + data.getId();
        DataResponse<AuthorEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()) {
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }
}