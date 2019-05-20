package test.demo.restful.bean;

import java.util.List;

public class Result {
    private boolean success;
    private List data;

    public boolean isSuccess() {
        return success;
    }

    public List getData() {
        return data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(List data) {
        this.data = data;
    }
}
