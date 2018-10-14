/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rectangle;

/**
 *
 * @author qxz14sru
 */
public interface ADT_BasicRect
{
/**
    Provided the cut-value is strictly between 0 and
    the height of this BasicRect, the height of this
    is changed to the cut-value. The BasicRect
    representing the lower part of the cut is returned.
    @param c the cut value
    @return the lower part of the cut
    If the cut-value is not strictly between 0 and
    the height of this, an IllegalArgumentException is thrown
*/
    public BasicRect horizontalCut( int c );
/**
    Provided the cut-value is strictly between 0 and
    the width of this BasicRect, the width of this
    is changed to the cut-value. The BasicRect
    representing the right-hand part of the cut is returned.
    @param c the cut value
    @return the right-hand part of the cut
    If the cut-value is not strictly between 0 and
    the width of this, an IllegalArgumentException is thrown
*/
    public BasicRect verticalCut( int c );
}