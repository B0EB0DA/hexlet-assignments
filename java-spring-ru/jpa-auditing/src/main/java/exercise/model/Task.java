package exercise.model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;


//id – уникальный идентификатор id, генерируется автоматически базой данных
//title — название задачи
//description – описание задачи
//createdAt – дата создания новой задачи
//updatedAt – дата последнего обновления задачи
// BEGIN
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String title;
    private String description;
    @LastModifiedDate
    private LocalDate updatedAt;
    @CreatedDate
    private LocalDate createdAt;
}
// END

