package com.example.casadocodigo.novoCliente;

import com.example.casadocodigo.compartilhado.CpfOrCnpj;
import com.example.casadocodigo.compartilhado.UniqueValue;
import com.example.casadocodigo.compartilhado.ValueExists;
import com.example.casadocodigo.compartilhado.VerificaSeNaoTemEstados;
import com.example.casadocodigo.novoLocal.Estado;
import com.example.casadocodigo.novoLocal.EstadoRepository;
import com.example.casadocodigo.novoLocal.Pais;
import com.example.casadocodigo.novoLocal.PaisRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Locale;
import java.util.Optional;

@VerificaSeNaoTemEstados
public class FormClienteRequest {
    @NotBlank
    @Email
    @UniqueValue(fieldName = "email", domainClass = Cliente.class)
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @CpfOrCnpj
    @UniqueValue(fieldName = "documento", domainClass = Cliente.class)
    private String documento;
    @NotBlank
    private String logradouro;
    @NotNull
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ValueExists(fieldName = "id", domainClass = Pais.class)
    private Long paisId;
    @JsonProperty(required = false)
    private String estadoNome;
    @NotBlank
    @Size(max = 20)
    private String telefone;
    @NotBlank
    @Size(max = 10)
    private String cep;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public String getEstadoNome() {
        return estadoNome;
    }

    public void setEstadoNome(String estadoNome) {
        this.estadoNome = estadoNome.toUpperCase(Locale.ROOT);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        Pais pais = paisRepository.findById(paisId).get();
        Optional<String> estadoPodeExistir = Optional.ofNullable(estadoNome);
        Estado estado = null;
        if (estadoPodeExistir.isPresent()) {
            estado = estadoRepository.findByNomeAndPaisId(estadoNome, pais.getId()).get();
        }
        return new Cliente(email, nome, sobrenome, documento, logradouro, complemento, cidade, pais, estado, telefone, cep);
    }
}