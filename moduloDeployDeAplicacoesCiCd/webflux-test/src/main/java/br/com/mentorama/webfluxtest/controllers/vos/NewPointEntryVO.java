package br.com.mentorama.webfluxtest.controllers.vos;

import br.com.mentorama.webfluxtest.model.EntryType;

import java.io.Serializable;

public class NewPointEntryVO implements Serializable {

    private String userId;
    private EntryType type;
    private Long value;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public EntryType getType() {
        return type;
    }

    public void setType(EntryType type) {
        this.type = type;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "NewPointEntryVO{" +
                "userId='" + userId + '\'' +
                ", type=" + type +
                ", value=" + value +
                '}';
    }
}
