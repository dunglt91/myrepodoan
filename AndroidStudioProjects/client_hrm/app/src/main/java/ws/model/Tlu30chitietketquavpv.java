package ws.model;

/**
 * Created by dunglt on 6/24/16.
 */
public class Tlu30chitietketquavpv {
    private Integer id;
    private String tendkpv;
    private String madkpv;
    private String machitietdmkqpv;
    private float diemcandat;
    private float diemdatduoc;

    public Tlu30chitietketquavpv() {
    }

    public Tlu30chitietketquavpv(String tendkpv, String madkpv, String machitietdmkqpv, float diemcandat, float diemdatduoc) {
        this.tendkpv = tendkpv;
        this.madkpv = madkpv;
        this.machitietdmkqpv = machitietdmkqpv;
        this.diemcandat = diemcandat;
        this.diemdatduoc = diemdatduoc;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTendkpv() {
        return this.tendkpv;
    }

    public void setTendkpv(String tendkpv) {
        this.tendkpv = tendkpv;
    }
    public String getMadkpv() {
        return this.madkpv;
    }

    public void setMadkpv(String madkpv) {
        this.madkpv = madkpv;
    }
    public String getMachitietdmkqpv() {
        return this.machitietdmkqpv;
    }

    public void setMachitietdmkqpv(String machitietdmkqpv) {
        this.machitietdmkqpv = machitietdmkqpv;
    }
    public float getDiemcandat() {
        return this.diemcandat;
    }

    public void setDiemcandat(float diemcandat) {
        this.diemcandat = diemcandat;
    }
    public float getDiemdatduoc() {
        return this.diemdatduoc;
    }

    public void setDiemdatduoc(float diemdatduoc) {
        this.diemdatduoc = diemdatduoc;
    }
}
