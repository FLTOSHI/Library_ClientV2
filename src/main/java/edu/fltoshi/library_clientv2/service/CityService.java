package edu.fltoshi.library_clientv2.service;

import edu.fltoshi.library_clientv2.entity.CityEntity;
import edu.fltoshi.library_clientv2.response.BaseResponse;
import edu.fltoshi.library_clientv2.response.DataResponse;
import edu.fltoshi.library_clientv2.response.ListResponse;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.lang.reflect.Type;
public class CityService {
    @Getter
    private ObservableList<CityEntity> data = FXCollections.observableArrayList();
    private final HTTPService http = new HTTPService();
    JSONService service = new JSONService();
    ClientProperties properties = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<CityEntity>>() {
    }.getType();
    private Type listType = new TypeToken<ListResponse<CityEntity>>() {
    }.getType();

    public void getAll() {
        ListResponse<CityEntity> data = new ListResponse<>();
        data = service.getObject(http.get(properties.getAllCity()), listType);
        if (data.isSuccess()) {
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
    }

    public void add(CityEntity data) {
        String temp = http.post(properties.getSaveCity(), service.getJson(data));
        DataResponse<CityEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()) {
            this.data.remove(data);
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void delete(CityEntity data) {
        String temp = http.delete(properties.getDeleteCity(), data.getId());
        DataResponse<CityEntity> response = service.getObject(temp, BaseResponse.class);
        if (response.isSuccess()) {
            this.data.remove(data);
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void findById(CityEntity data) {
        String temp = http.get(properties.getFindByIdCity()) + data.getId();
        DataResponse<CityEntity> response = service.getObject(temp, dataType);
        if (response.isSuccess()) {
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }
}