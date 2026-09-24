package ifgram.service;
import ifgram.dto.UserRequest;
import ifgram.dto.UserResponse;
import ifgram.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Email;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    // injeção de dependêcia pelo construtor
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserResponse cria(UserRequest request) {
        // regra de negócios: o e-mail não pode repetir
        if (repository.existsByEmail(request.email())) {
            throw new EmailDuplicadoexception(request.email());
        }
        user salvo = repository.save(new User(request.nome(), request.email()));
        return UserResponse.from(salvo);
    }
}
