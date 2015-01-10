import java.util.Vector;
/**
 * Write a description of class TabelNasabah here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TabelNasabah
{
   private Vector<Nasabah> daftarNasabah=new Vector<Nasabah>();

    /**
     * Constructor for objects of class TabelNasabah
     */
    public TabelNasabah()
    {
        // initialise instance variables
        //data nasabah default 
        tambah(new Nasabah("James","1234","Kutisari","8495664",100000));
        tambah(new Nasabah("Riyu","1235","Rungkut I","3495664",50000));
        tambah(new Nasabah("Ken","1238","Kedungbaruk","6495664",90000));
        tambah(new Nasabah("Lee","1239","Manyar","7495664",120000));
    }

    public void tambah(Nasabah nBaru){
        daftarNasabah.add(nBaru);
    }
    public void tarikTunai(String noRek, int jmlTarikTunai){
        //cari data rek by noRek
        //jika ketemu maka lakukan tarik tunai pada index tsb
        int idx=cari(noRek);
        if(idx!=-1)
        {
            //tarik tunai
            daftarNasabah.elementAt(idx).tarikTunai(jmlTarikTunai);
        }else{
            System.out.println("NO REK " + noRek + " TIDAK ADA DI DB KAMI");
        }
    }
    public void transfer(String noRekAsal, String noRekTujuan, int jmlTransfer){
    //1.cari rekAsal
    //2.cari rekTujuan
    //3.jika ketemu semua
    //4. tarik tunai rekAsal
    //5. setor tunai rekTujuan
        int idx1=cari(noRekAsal);
        int idx2=cari(noRekTujuan);
        if((idx1!=-1)&&(idx2!=-1))
        {
            daftarNasabah.elementAt(idx1).transfer(daftarNasabah.elementAt(idx2),jmlTransfer);
        }else{
        //noRek tidak ketemu
            System.out.println("Rekening Asal atau Tujuan Tidak Ditemukan");
        }
    }
    public int cari(String noRek){
        int index=-1;
        int i=0;
        do{
            if(daftarNasabah.elementAt(i).getNoRek().equals(noRek))
                index=i;
            i++;
        }while((i<daftarNasabah.size())&&(index==-1));
        return index;
    }
}
