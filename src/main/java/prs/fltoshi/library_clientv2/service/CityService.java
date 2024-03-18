package prs.fltoshi.library_clientv2.service;

import prs.fltoshi.library_clientv2.entity.CityEntity;
import prs.fltoshi.library_clientv2.response.BaseResponse;
import prs.fltoshi.library_clientv2.response.DataResponse;
import prs.fltoshi.library_clientv2.response.ListResponse;
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
    private Type listType = new TypeToken<DataResponse<CityEntity>>() {
    }.getType();

    public void getAll() {
        ListResponse<CityEntity> data = new ListResponse<>();
        data = service.getObject(http.get(properties.allCity), listType);
        if (data.getSuccess()) {
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
    }

    public void add(CityEntity data) {
        String temp = http.post(properties.saveCity, service.getJson(data));
        DataResponse<CityEntity> response = service.getObject(temp, dataType);
        if (response.getSuccess()) {
            this.data.remove(data);
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void delete(CityEntity data) {
        String temp = http.delete(properties.deleteCity, data.getId());
        DataResponse<CityEntity> response = service.getObject(temp, BaseResponse.class);
        if (response.getSuccess()) {
            this.data.remove(data);
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void findById(CityEntity data) {
        String temp = http.get(properties.findByIdCity) + data.getId();
        DataResponse<CityEntity> response = service.getObject(temp, dataType);
        if (response.getSuccess()) {
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }
}