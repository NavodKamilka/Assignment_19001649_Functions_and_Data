object rationalobj extends App{
  val x =new Rational(3,4)
  val y = new Rational(5,8)
  val z = new Rational(2,7)
  val answer =  x+y.neg+z.neg
  println(answer)

}


class Rational(x:Int,y:Int){

  require(y>0,"y must be larger than 0")

  private  def gcd(a:Int,b:Int):Int = b match{
    case 0=>a
    case b if b>a=>gcd(b,a)
    case _ => gcd(b,a%b)
  }
  private  val g =gcd((x).abs,(y).abs)
  def numer = x/g
  def denom =  y/g

  def this(n:Int)=this(n,1)

  def +(r:Rational)=new Rational(this.numer*r.denom+this.denom*r.numer,this.denom*r.denom)
  override def toString=numer +"/" +denom
  def neg = new Rational(-(this.numer),this.denom)
  def -(r:Rational) = this + r.neg


}