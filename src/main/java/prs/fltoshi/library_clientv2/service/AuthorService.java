package prs.fltoshi.library_clientv2.service;

import prs.fltoshi.library_clientv2.entity.AuthorEntity;
import prs.fltoshi.library_clientv2.response.BaseResponse;
import prs.fltoshi.library_clientv2.response.DataResponse;
import prs.fltoshi.library_clientv2.response.ListResponse;
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
    private Type listType = new TypeToken<DataResponse<AuthorEntity>>() {
    }.getType();

    public void getAll() {
        ListResponse<AuthorEntity> data = new ListResponse<>();
        data = service.getObject(http.get(properties.allAuthors), listType);
        if (data.getSuccess()) {
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
    }

    public void add(AuthorEntity data) {
        String temp = http.post(properties.saveAuthor, service.getJson(data));
        DataResponse<AuthorEntity> response = service.getObject(temp, dataType);
        if (response.getSuccess()) {
            this.data.remove(data);
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void delete(AuthorEntity data) {
        String temp = http.delete(properties.deleteAuthor, data.getId());
        DataResponse<AuthorEntity> response = service.getObject(temp, BaseResponse.class);
        if (response.getSuccess()) {
            this.data.remove(data);
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void findById(AuthorEntity data) {
        String temp = http.get(properties.findByIdAuthor) + data.getId();
        DataResponse<AuthorEntity> response = service.getObject(temp, dataType);
        if (response.getSuccess()) {
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }
}