
/**
 * Write a description of class Nasabah here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nasabah
{
    public static final int MIN_SALDO = 10000;
   private String nama;
   private String noRek;
   private String alamat;
   private String noTelp;
   private int saldo;
   
    /**
     * Constructor for objects of class Nasabah
     */
    public Nasabah()
    {
        // initialise instance variables
        
    }
    /**
     * Contructor @nama, @noRek..
     * contoh method MANAGER
     */
    public Nasabah(String nama, String noRek, String alamat, String noTelp, int saldo){
        this.nama=nama;
        this.noRek=noRek;
        this.alamat=alamat;
        this.noTelp=noTelp;
        this.saldo=saldo;
    }
    
    //public hapus(){
    
   // }
            //contoh method ACCESS - setter/getter
    public void setNama(String nama){
        this.nama=nama;
    }
        //contoh method ACCESS - setter/getter    
   public String getNama(){
        return nama;
    }
        //contoh method ACCESS - setter/getter
    public int getSaldo(){
        return saldo;
    }
        //contoh method IMPLEMENTOR
    public void tarikTunai(int jmlTarikTunai){
        //check saldo setelah penarikan tunai harus > SALDO_MIN
        if(checkSaldo(jmlTarikTunai))
        saldo -=jmlTarikTunai;
        else
        System.out.println("Saldo harus lebih dari saldo min= " + MIN_SALDO);
    }
        //contoh method IMPLEMENTOR
    public void setorTunai(int jmlSetor){
        saldo +=jmlSetor;
    }
    //contoh method IMPLEMENTOR
    public void transfer(Nasabah tujuan,int jmlTransfer){
        //1.check saldo
        if(checkSaldo(jmlTransfer))
        {
        tarikTunai(jmlTransfer);
        tujuan.setorTunai(jmlTransfer);
    }else
    System.out.println("TRANSFER GAGAL !");
    }
    //contoh method HELPER
    private boolean checkSaldo(int jml){
        return ((saldo-jml)>MIN_SALDO);
    }
    public String getNoRek(){
        return noRek;
    }
}
