package org.brainacad.model;

import javax.persistence.*;
import java.util.Date;

@Entity // аннотация помечающая класс как персистентную сущность
@Table(name = "users", schema = "upsproject") // укзание что данный класс соответствует таблице в БД
public class User {

    @Id // указание что это поле являеться ключем
    // Описание последовательности для генерации ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column // аннотация помечающая поле как колонку в таблице БД, название должно соответствовать
    private Long id;

    @Column(nullable = false, name = "login") // установка запрета на сохранение null значений
    private String email;

    @Column
    private String password;

    // Можно указать другое название, если явно указать имя колонки в параметре name
    // Или можно назвать переменную, заменив разделители на camelCase ( createAt )
    @Column(name = "created_at")
    private Date creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}

