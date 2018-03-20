import java.util.*;
import java.io.*;

class MissedPhone 
{
	String name, phoneNo, time;

	MissedPhone(String n, String p, String t)
	{
		name = n;
		phoneNo = p;
		time = t;
	}

	public String toString()
	{
		return "\nName: " + name + "\nPhone No: " + phoneNo + "\nTime: " + time;
	}
}

class Phone
{
	String name_a, phoneNo_a;

	Phone(String n, String p)
	{
		name_a = n;
		phoneNo_a = p;
	}
}

class newPhoneClass
{
	public static void main(String[] args)
	{
		int count = 0;
		Scanner sc = new Scanner(System.in);
		Calendar c = Calendar.getInstance();
		HashMap<Integer, Phone> alist = new HashMap<Integer, Phone>();
		ArrayList<MissedPhone> mlist = new ArrayList<MissedPhone>();
		alist.put(1, new Phone("ABC", "1234"));
		alist.put(2, new Phone("DEF", "5678"));
		alist.put(3, new Phone("GHI", "9012"));
		alist.put(4, new Phone("JKL", "3456"));
		alist.put(5, new Phone("Private", "7890"));
		alist.put(6, new Phone("Private", "1357"));
		alist.put(7, new Phone("Private", "2468"));

		while(true)
		{
			System.out.println("\n1) Add\n2) Log\n3) Delete\n4) Exit: ");
			int ch = sc.nextInt();
			switch(ch)
			{
				case 1:
				if(count > 10)
				{
					mlist.remove(0);
					count--;
				}
				Random rand = new Random();
				int num1 = rand.nextInt(7)+1;
				Phone obj1 = alist.get(num1);
				int H = c.get(Calendar.HOUR);
				int M = c.get(Calendar.MINUTE);
				int S = c.get(Calendar.SECOND);
				String time1 = H + ":" + M + ":" + S;
				mlist.add(new MissedPhone(obj1.name_a, obj1.phoneNo_a, time1));
				count++;
				break;

				case 2:
				for(int i = 0; i < mlist.size(); i++)
				{
					MissedPhone obj2 = mlist.get(i);
					System.out.println("\nName: " + obj2.name + "\nPhone No: " + obj2.phoneNo + "\nTime: " + obj2.time);
					System.out.println("\n1) Display next\n2) Display next and delete current: ");
					int ch1 = sc.nextInt();
					switch(ch1)
					{
						case 1:
						continue;

						case 2:
						mlist.remove(i);
						i--;
						count--;
						continue;
					}
				}
				break;

				case 3:
				System.out.println("\nEnter number to delete: ");
				Scanner sc1 = new Scanner(System.in);
				String delNum = sc1.nextLine();
				for(int i = 0; i < mlist.size(); i++)
				{
					MissedPhone obj2 = mlist.get(i);
					if(obj2.phoneNo.equals(delNum))
					{
						mlist.remove(i);
						count--;
						System.out.println("Deleted! (" + delNum + ")");
					}
				}
				break;

				case 4:
				System.exit(0);
			}
		}
	}
}