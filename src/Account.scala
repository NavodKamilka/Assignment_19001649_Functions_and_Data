object accountobj extends App{

  var bank:List[Account]=List(new Account("account1",1001,17000.50),new Account("account2",1002,-15000.70),new Account("account3",1003,20200.00),new Account("account4",1004,-5950.00))
  def isNegative=(l:Account)=>l.balance<0
  def negativeBalance=bank.filter(isNegative)

  def balance = (l:Account)=>l.balance
  var total = bank.map(balance).reduce((x,y)=>(x+y))

  val interest=(l:Account)=>if (l.balance<0) l.balance=l.balance-l.balance*0.1/100 else l.balance=l.balance+l.balance*0.5/100
  val x=bank.map(interest)

  println(bank)

}
class  Account(id:String,n:Int,b:Double){
  var nic:String=id
  var acnumber:Int=n
  var balance:Double=b

  override def toString="["+nic+":"+acnumber+":"+balance+"]"

  def withdraw(a:Double){
    this.balance=this.balance-a
  }

  def deposit(a:Double){
    this.balance=this.balance+a
  }

  def transfer(a:Account,b:Double){
    a.deposit(b)
    this.withdraw(b)
  }


}