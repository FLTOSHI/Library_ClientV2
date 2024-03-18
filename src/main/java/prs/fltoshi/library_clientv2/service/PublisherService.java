package prs.fltoshi.library_clientv2.service;

import prs.fltoshi.library_clientv2.entity.PublisherEntity;
import prs.fltoshi.library_clientv2.response.BaseResponse;
import prs.fltoshi.library_clientv2.response.DataResponse;
import prs.fltoshi.library_clientv2.response.ListResponse;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.lang.reflect.Type;
public class PublisherService {
    @Getter
    private ObservableList<PublisherEntity> data = FXCollections.observableArrayList();
    private final HTTPService http = new HTTPService();
    JSONService service = new JSONService();
    ClientProperties properties = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<PublisherEntity>>() {
    }.getType();
    private Type listType = new TypeToken<DataResponse<PublisherEntity>>() {
    }.getType();

    public void getAll() {
        ListResponse<PublisherEntity> data = new ListResponse<>();
        data = service.getObject(http.get(properties.allPublisher), listType);
        if (data.getSuccess()) {
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
    }

    public void add(PublisherEntity data) {
        String temp = http.post(properties.savePublisher, service.getJson(data));
        DataResponse<PublisherEntity> response = service.getObject(temp, dataType);
        if (response.getSuccess()) {
            this.data.remove(data);
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void delete(PublisherEntity data) {
        String temp = http.delete(properties.deletePublisher, data.getId());
        DataResponse<PublisherEntity> response = service.getObject(temp, BaseResponse.class);
        if (response.getSuccess()) {
            this.data.remove(data);
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }

    public void findById(PublisherEntity data) {
        String temp = http.get(properties.findByIdPublisher) + data.getId();
        DataResponse<PublisherEntity> response = service.getObject(temp, dataType);
        if (response.getSuccess()) {
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }
}