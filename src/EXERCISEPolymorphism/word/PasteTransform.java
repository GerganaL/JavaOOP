package EXERCISEPolymorphism.word;

public class PasteTransform  implements TextTransform{
    private CutTransform cutTransform;

    public PasteTransform(CutTransform cutTransform){
        this.cutTransform = cutTransform;
    }
    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
       // text.insert(startIndex,cutTransform.getLastCut());
        text.replace(startIndex,endIndex,cutTransform.getLastCut().toString());
    }
}
