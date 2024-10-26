import java.util.*;

public class CompositePattern {
    public static void main(String[] args){
        // 父类名 对象名 = new 子类名
        AbstractFile root = new Folder("root");

        AbstractFile folderA = new Folder("FolderA");
        AbstractFile folderB = new Folder("FolderB");
        AbstractFile fileA = new File("fileA");
        AbstractFile folderC = new Folder("FolderC");
        AbstractFile folderD = new Folder("FolderD");
        AbstractFile fileB = new File("fileB");

        root.Add(folderA);
        root.Add(folderB);
        root.Add(fileA);

        folderA.Add(folderC);
        folderA.Add(folderD);
        folderA.Add(fileB);

        print(root);

    }

    static void print(AbstractFile file){
        file.printName();
        file.getchildren();
        List<AbstractFile> childrenlist = file.getchildren();
        if (childrenlist == null) return;
        // for (对象类型 对象名：遍历对象)
        for(AbstractFile children : childrenlist){  //循环获取文件夹下所有文件
            print(children);
        }
    }
}

abstract class AbstractFile{
    protected String name;

    public void printName(){
        System.out.println(name);
    }

    public abstract boolean Add(AbstractFile file);
    public abstract boolean Remove(AbstractFile file);
    public abstract List<AbstractFile> getchildren();


}


class Folder extends AbstractFile{
    private List<AbstractFile> childrenlist = new ArrayList<AbstractFile>();


    public Folder(String name){
        this.name = name;
    }
    @Override
    public boolean Add(AbstractFile file){
        return childrenlist.add(file);
    }

    @Override
    public boolean Remove(AbstractFile file){
        return childrenlist.remove(file);
    }

    @Override
    public List<AbstractFile>getchildren(){
        return childrenlist;
    }

}


class File extends AbstractFile{
    public File(String name){
        this.name = name;
    }
    @Override
    public boolean Add(AbstractFile file){
        return false;
    }
    @Override
    public boolean Remove(AbstractFile file){
        return false;
    }

    @Override
    public List<AbstractFile> getchildren(){
        return null;
    }
}

