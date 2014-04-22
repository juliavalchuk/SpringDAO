package ua.epam.spring.domain;

import java.util.List;

/**
 * Created by julia
 */
public class Book {
    Integer bookId;
    String bookTitle;
    String bookInformation;
    Double bookMortgage;
    Double bookRent;
    List<Writer> writers;
    List<Genre> genres;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookInformation() {
        return bookInformation;
    }

    public void setBookInformation(String bookInformation) {
        this.bookInformation = bookInformation;
    }

    public Double getBookMortgage() {
        return bookMortgage;
    }

    public void setBookMortgage(Double bookMortgage) {
        this.bookMortgage = bookMortgage;
    }

    public Double getBookRent() {
        return bookRent;
    }

    public void setBookRent(Double bookRent) {
        this.bookRent = bookRent;
    }

    public List<Writer> getWriters() {
        return writers;
    }

    public void setWriters(List<Writer> writers) {
        this.writers = writers;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
