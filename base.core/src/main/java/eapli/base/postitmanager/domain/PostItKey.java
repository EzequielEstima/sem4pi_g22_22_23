package eapli.base.postitmanager.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class PostItKey implements Comparable<PostItKey>, ValueObject {
    private PostItIdentifier postItIdentifier;
    private PostItVersion postItVersion;

    protected PostItKey(PostItIdentifier postItIdentifier, PostItVersion postItVersion){
        this.postItIdentifier = postItIdentifier;
        this.postItVersion = postItVersion;
    }

    protected PostItKey(){
        //ORM use only
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostItKey that = (PostItKey) o;
        return postItIdentifier.equals(that.postItIdentifier) && (postItVersion.equals(that.postItVersion));
    }

    @Override
    public int hashCode() {
        return Objects.hash(postItIdentifier);
    }

    @Override
    public int compareTo(PostItKey o) {
        return 0;
    }

    public void updateVersion() {
        this.postItVersion.updateVersion();
    }

    public int returnPostItVersion() {
        return this.postItVersion.returnVersion();
    }
    public long returnPostItIdentifier() {
        return this.postItIdentifier.returnIdentifier();
    }
    @Override
    public String toString() {
        return postItIdentifier.toString();
    }
}
