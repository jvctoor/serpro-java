package mysql;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

public class UsuarioTest {

    Usuario joao = new Usuario(1L, "João Victor", "jvctor23@gmail.com", 20, new Date());

    @Test
    @DisplayName("Usuário precisa ter 18 anos")
    void userShoulBe18Years() {
        Assertions.assertThat(joao.getIdade()).isGreaterThan(18);
    }


}
