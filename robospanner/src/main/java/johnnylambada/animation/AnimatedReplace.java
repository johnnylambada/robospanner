package johnnylambada.animation;

import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nineoldandroids.animation.Animator;

/**
 * Created by john on 12/7/14.
 */
public class AnimatedReplace {
    public final static int ANIM_DURATION = 400;
    public enum Orientation {
        Horizontal(
            new Techniques[]{Techniques.SlideOutLeft, Techniques.SlideInRight},
            new Techniques[]{Techniques.SlideInLeft, Techniques.SlideOutRight}
        ),
        Vertical(
            new Techniques[]{Techniques.SlideOutUp, Techniques.SlideInUp},
            new Techniques[]{Techniques.SlideInDown, Techniques.SlideOutDown}
        ),
        ;
        Techniques[] in,out;
        Orientation(Techniques[] in, Techniques[] out){
            this.in = in;
            this.out = out;
        }
    }
    private AnimatedReplace(){}
    private View firstView,secondView;
    private Animator.AnimatorListener firstListener,secondListener;

    private Orientation orientation;
    private Techniques[] techniques;
    public static AnimatedReplace goIn(Orientation orientation){
        AnimatedReplace dis = new AnimatedReplace();
        dis.orientation = orientation;
        dis.techniques = orientation.in;
        return dis;
    }
    public static AnimatedReplace goOut(Orientation orientation){
        AnimatedReplace dis = new AnimatedReplace();
        dis.orientation = orientation;
        dis.techniques = orientation.out;
        return dis;
    }
    public AnimatedReplace firstView(View val){firstView = val; return this;}
    public AnimatedReplace secondView(View val){secondView = val; return this;}
    public AnimatedReplace firstListener(Animator.AnimatorListener val){firstListener = val; return this;}
    public AnimatedReplace secondListener(Animator.AnimatorListener val){secondListener = val; return this;}

    public void execute(){
        if (firstView==null || secondView==null)
            throw new IllegalArgumentException("Neither view can be null");

        YoYo.AnimationComposer firstComposer = YoYo.with(techniques[0])
            .duration(ANIM_DURATION);
        if (firstListener!=null)
            firstComposer.withListener(firstListener);
        firstComposer.playOn(firstView);

        YoYo.AnimationComposer secondComposer = YoYo.with(techniques[1])
            .duration(ANIM_DURATION);
        if (secondListener!=null)
            secondComposer.withListener(secondListener);
        secondComposer.playOn(secondView);
    }
}
