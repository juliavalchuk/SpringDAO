package ua.epam.spring.library.writer;

/**
 * Created by julia
 */
public class Writer {
    private Integer writerId;
    private String writerName;

    public Writer() {
    }

    public Writer(String writerName) {
        this.writerName = writerName;
    }

    public Integer getWriterId() {
        return writerId;
    }

    public void setWriterId(Integer writerId) {
        this.writerId = writerId;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }


}
