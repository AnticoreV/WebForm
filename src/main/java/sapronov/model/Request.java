package sapronov.model;

import java.util.Objects;

public class Request {
    private String req_text;

    public String getReq() {
        return req_text;
    }

    public Request(String req_text) {
        this.req_text = req_text;
    }

    @Override
    public int hashCode() {
        return Objects.hash(req_text);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){return true;}
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Request request = (Request) obj;
        return req_text == request.req_text;
    }
}
