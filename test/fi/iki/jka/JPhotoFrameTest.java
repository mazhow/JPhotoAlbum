package fi.iki.jka;


import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class JPhotoFrameTest {

    @Test
    public void callSlideShowWithEmptyPhotoCollectionReturnsNothingToShow() throws Exception {

        JPhotoCollection jPhotoCollection = new JPhotoCollection();
        JPhotoFrame jPhotoFrame = new JPhotoFrame(jPhotoCollection);
        ActionEvent actionEvent = new ActionEvent(this, 0, JPhotoMenu.A_SLIDESHOW);

        jPhotoFrame.actionPerformed(actionEvent);
        assertThat(jPhotoFrame.getSlideShowFlag(), is(2));

    }

    @Test
    public void callSlideShowWithPhotoCollectionShowsPhotos() throws Exception {

        JPhotoCollection jPhotoCollection = new JPhotoCollection();
        jPhotoCollection.setTitle("Test Collection");

        ArrayList<JPhoto> photos = new ArrayList<>();
        photos.add(new JPhoto());
        jPhotoCollection.setPhotos(photos);

        JPhotoFrame jPhotoFrame = new JPhotoFrame(jPhotoCollection);
        ActionEvent actionEvent = new ActionEvent(this, 0, JPhotoMenu.A_SLIDESHOW);

        jPhotoFrame.actionPerformed(actionEvent);

        assertThat(jPhotoFrame.getSlideShowFlag(), is(1));

    }
}