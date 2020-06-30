package framework;

/**
 * @author jx
 * @date 2020/6/29 21:27
 */
public class URL {

    private String hostname;
    private Integer port;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public URL(String hostname, Integer port) {
        this.hostname = hostname;
        this.port = port;
    }
}
