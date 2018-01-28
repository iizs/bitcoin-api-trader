package net.iizs.btc.trader.model;

public class ApiResponse {
    protected int status;
    protected String errorMsg;

    public ApiResponse() {
        this.status = 0;
        this.errorMsg = null;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "status=" + status +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
