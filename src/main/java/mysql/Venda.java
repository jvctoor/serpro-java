package mysql;


import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "venda")
//@SequenceGenerator(name = "vendaSec", sequenceName = "vendaSec", initialValue = 1, allocationSize = 1)
public class Venda {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendaSec")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name="data_da_venda")
    private Date data_venda;

    private Double valor_total;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Venda() {

    }

    public Venda(Long id, Date data_venda, Double valor_total, Usuario id_usuario) {
        this.id = id;
        this.data_venda = data_venda;
        this.valor_total = valor_total;
        this.usuario = id_usuario;
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

    public Usuario getIdUsuario() {
        return this.usuario;
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

    public void setIdUsuario(Usuario id) {
        this.usuario = id;
    }


}
