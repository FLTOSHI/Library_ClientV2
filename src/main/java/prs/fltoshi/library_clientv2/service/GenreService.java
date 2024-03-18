package prs.fltoshi.library_clientv2.service;

import prs.fltoshi.library_clientv2.entity.GenreEntity;
import prs.fltoshi.library_clientv2.response.BaseResponse;
import prs.fltoshi.library_clientv2.response.DataResponse;
import prs.fltoshi.library_clientv2.response.ListResponse;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.lang.reflect.Type;
public class GenreService {
    @Getter
    private ObservableList<GenreEntity> data = FXCollections.observableArrayList();
    private final HTTPService http = new HTTPService();
    JSONService service = new JSONService();
    ClientProperties properties = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<GenreEntity>>() {
    }.getType();
    private Type listType = new TypeToken<DataResponse<GenreEntity>>() {
    }.getType();

    public void getAll() {
        ListResponse<GenreEntity> data = new ListResponse<>();
        data = service.getObject(http.get(properties.getAllGenre), listType);
        if (data.getSuccess()) {
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
    }

    public void add(GenreEntity data) {
        String temp = http.post(properties.saveGenre, service.getJson(data));
        DataResponse<GenreEntity> response = service.getObject(temp, dataType);
        if (response.getSuccess()) {
            this.data.remove(data);
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void delete(GenreEntity data) {
        String temp = http.delete(properties.deleteGenre, data.getId());
        DataResponse<GenreEntity> response = service.getObject(temp, BaseResponse.class);
        if (response.getSuccess()) {
            this.data.remove(data);
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void findById(GenreEntity data) {
        String temp = http.get(properties.findByIdGenre) + data.getId();
        DataResponse<GenreEntity> response = service.getObject(temp, dataType);
        if (response.getSuccess()) {
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }
}