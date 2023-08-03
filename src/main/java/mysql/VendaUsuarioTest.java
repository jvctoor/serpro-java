package mysql;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Date;

public class VendaUsuarioTest {

    @Test
    void inserirVenda() throws Exception {
        VendaDAO_JPA dao = new VendaDAO_JPA();

        UsuarioDAO_JPA usuario_dao = new UsuarioDAO_JPA();
        Usuario usuario = usuario_dao.getById(1L);

        Venda venda = new Venda();
        venda.setValorTotal(220.30);
        venda.setDataVenda(new Date());
        venda.setIdUsuario(usuario);
        dao.salvar(venda);
    }

}
