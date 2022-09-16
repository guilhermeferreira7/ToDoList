package br.edu.utfpr.todolist.model.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data(staticConstructor = "of")
@NoArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String username;
    @NonNull
    private String password;
}
