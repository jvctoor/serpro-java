package mysql;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "venda")
@SequenceGenerator(name = "vendaSec", sequenceName = "vendaSec", initialValue = 1, allocationSize = 1)
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendaSec")
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date data_venda;

    private Double valor_total;

    private Long id_usuario;

    public Venda() {

    }

    public Venda(Long id, Date data_venda, Double valor_total, Long id_usuario) {
        this.id = id;
        this.data_venda = data_venda;
        this.valor_total = valor_total;
        this.id_usuario = id_usuario;
    }

    public Long getId() {
        return this.id;
    }

    public Date getData() {
        return this.data_venda;
    }

    public Double getValor_total() {
        return this.valor_total;
    }

    public Long getIdUsuario() {
        return this.id_usuario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataVenda(Date data) {
        this.data_venda = data;
    }

    public void setValorTotal(Double valor) {
        this.valor_total = valor;
    }

    public void setIdUsuario(Long id) {
        this.id_usuario = id;
    }


}
