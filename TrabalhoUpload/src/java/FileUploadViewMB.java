/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Win7
 */

@ManagedBean(name="UploadMB")
@ViewScoped
public class FileUploadViewMB {
     
    private UploadedFile file;
    private String texto;
    
    
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Sucesso", file.getFileName() + " o arquivo foi carregado.");
            FacesContext.getCurrentInstance().addMessage(null, message);
                      
        }
    }
     
    public void handleFileUpload(FileUploadEvent event) throws IOException {
        texto = new Scanner(event.getFile().getInputstream(),"UTF-8").useDelimiter("\\A").next();
        System.out.println("texto");
        FacesMessage msg = new FacesMessage("Sucesso", event.getFile().getFileName() + " o arquivo foi carregado.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        
           
        
    }

    
    
    
    public FileUploadViewMB() {
        
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
  
}
   
    
    

