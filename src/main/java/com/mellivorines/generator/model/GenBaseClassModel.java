package com.mellivorines.generator.model;

import com.mellivorines.generator.entity.GenBaseClass;
import com.mellivorines.generator.entity.GenBaseClassProps;
import org.babyfish.jimmer.ImmutableConverter;

public class GenBaseClassModel {
    private static final ImmutableConverter<GenBaseClass, GenBaseClassModel> BOOK_CONVERTER =
            ImmutableConverter
                    .newBuilder(GenBaseClass.class, GenBaseClassModel.class)
                    .map(GenBaseClassProps.ID, mapping -> {
                        mapping.useIf(input -> input.id != null);
                    })
                    .autoMapOtherScalars(true)
                    .build();

    public GenBaseClass toGenAuthor() {
        return BOOK_CONVERTER.convert(this);
    }

    private Integer id;

    private String baseName;

    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
