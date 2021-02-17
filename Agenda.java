import java.util.ArrayList;
import java.util.List;

class Fone{
    public String label;
    public String number;
    
    public static boolean validate(String number){
        int quant = 0;
        String validar = "1234567890";
        String val[] = new String[10];
        String num[] = new String[number.length()];
        val = validar.split("");
        num = number.split("");
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < val.length; j++) {
                if(num[i].equals(val[j])){
                    quant++;
                }
            }
        }
        if(quant < number.length()){
            System.out.println("Numero invalido");
            return false;
        }else{
            return true;
        }
    }

    public Fone(String label, String number) {
        if(validate(number)){
            this.label = label;
            this.number = number;
        }
    }
    
    public Fone(int serial){
        
    }
    
    public String toString(){
        return label+":"+number;
    }
}

class Contato{
    private String name;
    private ArrayList<Fone> fone;
    
    public void procurarNull(){
        for (int i = 0; i < fone.size(); i++) {
            if(fone.get(i).label == null || fone.get(i).number == null){
                rmFone(i);
            }
        }
    }
    
    public void addFone(String label, String number){
        fone.add(new Fone(label, number));
        procurarNull();
    }
    
    public void rmFone(int index){
        fone.remove(index);
    }

    public Contato(String name, String label, String number) {
        fone = new ArrayList<Fone>();
        fone.add(new Fone(label, number));
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Fone> getFone() {
        return fone;
    }
    
    public String toString(){
        return "Nome:"+name+", Fone:"+fone;
    }
}


public class Agenda{
    private List<Contato> contatos;
    
    private int findContact(String name){
        for (int i = 0; i < contatos.size(); i++) {
            if(contatos.get(i).getName() == name){
                return i;
            }
        }
        return -1;
    }
    
    public boolean percorrer(String name){
        for (int i = 0; i < contatos.size(); i++) {
            if(contatos.get(i).getName() == name){
                
                return true;
            }
        }
        return false;
    }
    
    public void addContact(String name, Fone fone){
        if(percorrer(name)){
            System.out.println("Ja existe esse nome");
        }else{
            contatos.add(new Contato(name, fone.label, fone.number));   
        }
    }
    
    public boolean rmContact(String name){
        for (int i = 0; i < contatos.size(); i++) {
            if(contatos.get(i).getName() == name){
                contatos.remove(i);
                return true;
            }
        }
        System.out.println("Não existe esse contato");
        return false;
    }
    
    public ArrayList<Contato> search(String pattern){
        
        return null;
    }

    public List<Contato> getContact(String name) {
        return contatos;
    }
    
    public Agenda(){
        contatos = new ArrayList<Contato>();
    }

    public String toString(){
        return ""+contatos;
    }
    
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.addContact("eva", new Fone("oi", "2525"));
        agenda.addContact("eva", new Fone("oi", "2525"));
    }
    
}
