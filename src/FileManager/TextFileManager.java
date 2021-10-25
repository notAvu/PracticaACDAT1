package FileManager;

import Clases.Persona;

import java.io.*;

public class TextFileManager {
    File txtFile;
    BufferedWriter writer;
    BufferedReader reader;

    public TextFileManager()
    {
        txtFile=new File("InfoClientesTxt");
        iniReader();
        iniWriter();
    }

    private void iniReader()
    {
        try {
            reader=new BufferedReader(new FileReader(txtFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void iniWriter() {
        try {
            writer=new BufferedWriter(new FileWriter(txtFile));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void escribirCliente(Persona cliente)
    {
        iniWriter();
        try {
            writer.write(cliente.toString());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        closeWriter();
    }

    private void closeWriter() {
        try {
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
