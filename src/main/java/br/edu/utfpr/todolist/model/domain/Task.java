package br.edu.utfpr.todolist.model.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Data(staticConstructor = "of")
@NoArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String taskName;

    @NonNull
    private String description;

    @NonNull
    private boolean isCompleted;

    @NonNull
    private String dataCreated;

    private String dataCompleted;

    @ManyToOne
    @NonNull
    private User user;

}
