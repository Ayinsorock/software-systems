package ss.week2;

/**
 * P-2.1 --- P-2.5
 *
 * TODO: openJML warns about integer over/underflows. I should figure out why @public_invariant this.width < (int) 2e15 does not solve this.
 */

public class Rectangle {
  /**
   * @public_invariant this.width > 0 && this.width < (int) 2e15
   *                   this.length > 0 && this.length < (int) 2e15
   */

  private int width;
  private int length;

  /**
   * Create the rectangle
   *
   * @param width describes the rectangle width
   * @param length describes the rectangle height
   *
   * @require width > 0 && width < (int) 2e15
   *          height > 0 && height < (int) 2e15

   * @ensures  this.width == width
   *           this.height == height
   */
  public Rectangle(int width, int length) {
    assert width > 0;
    assert length > 0;

    this.width = width;
    this.length = length;
  }

  /**
   * @ensures \result == this.width * this.height
   */
  public int area() {
    assert this.width > 0;
    assert this.length > 0;

    return this.width * this.length;
  }

  /**
   * @ensures \result == this.width
   */
  public int width() {
    assert this.width > 0;

    return this.width;
  }

  /**
   * @ensures \result == this.length
   */
  public int length() {
    assert this.length > 0;

    return this.length;
  }

  /**
   * @ensures \result == 2 * (length() + width())
   */
  public int perimiter() {
    assert this.width > 0;
    assert this.length > 0;

    return 2 * (this.length + this.width);
  }
}
