package atl.academy.mvc.thymleaf.demo.response;

public class BaseResponse {
    private String statusCode;
    private String message;
    private Object data;

    public BaseResponse(String statusCode) {
        this.statusCode = statusCode;
    }

    public BaseResponse() {
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
