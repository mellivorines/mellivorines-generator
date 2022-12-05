package com.mellivorines.generator.model;

import com.mellivorines.generator.entity.GenAuthor;
import com.mellivorines.generator.entity.GenAuthorProps;
import org.babyfish.jimmer.ImmutableConverter;

public class GenAuthorModel {
    private static final ImmutableConverter<GenAuthor, GenAuthorModel> BOOK_CONVERTER =
            ImmutableConverter
                    .newBuilder(GenAuthor.class, GenAuthorModel.class)
                    .map(GenAuthorProps.ID, mapping -> {
                        mapping.useIf(input -> input.id != null);
                    })
                    .autoMapOtherScalars(true)
                    .build();

    public GenAuthor toGenAuthor() {
        return BOOK_CONVERTER.convert(this);
    }

    private Integer id;

    private String author;

    private String url;

    private String email;

    private String telephone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
