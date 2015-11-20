package com.mordreth.easyalertapp.app;

/**
 * Created by mordreth on 11/19/15.
 */
public class Service {
    long nit;
    String tiposervicio;
    String razonsocial;
    String direccion;
    long telefonofijovigilado;
    String correoelectronicovigilado;
    String representantelegal;

    public Service(long nit, String tiposervicio, String razonsocial, String direccion, long telefonofijovigilado, String correoelectronicovigilado, String representantelegal) {
        this.nit = nit;
        this.tiposervicio = tiposervicio;
        this.razonsocial = razonsocial;
        this.direccion = direccion;
        this.telefonofijovigilado = telefonofijovigilado;
        this.correoelectronicovigilado = correoelectronicovigilado;
        this.representantelegal = representantelegal;
    }

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    public String getTiposervicio() {
        return tiposervicio;
    }

    public void setTiposervicio(String tiposervicio) {
        this.tiposervicio = tiposervicio;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefonofijovigilado() {
        return telefonofijovigilado;
    }

    public void setTelefonofijovigilado(long telefonofijovigilado) {
        this.telefonofijovigilado = telefonofijovigilado;
    }

    public String getCorreoelectronicovigilado() {
        return correoelectronicovigilado;
    }

    public void setCorreoelectronicovigilado(String correoelectronicovigilado) {
        this.correoelectronicovigilado = correoelectronicovigilado;
    }

    public String getRepresentantelegal() {
        return representantelegal;
    }

    public void setRepresentantelegal(String representantelegal) {
        this.representantelegal = representantelegal;
    }
}
