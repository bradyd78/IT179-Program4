/*
 * Created on: Oct 19, 2022
 *
 * ULID: badavi4
 * Class: IT 168 
 */
package edu.ilstu;

/**
 * <Create an application for CVS customers>
 *
 * @author <Brady Davidson>
 *
 */
public class PrescriptionOrder
{
	private int numberRx;
	private String pharmacyBranch;
	private String drugName;
	private String drugType;
	private int eligibleRefills;
	private int maxRefills;
	private int usedRefills;
	static int totalPrescriptions;

	public PrescriptionOrder(int numberRx, String pharmacyBranch, String drugName, String drugType)
	{

		this.numberRx = numberRx;
		this.pharmacyBranch = ("CVS-" + pharmacyBranch);
		this.drugName = drugName.toUpperCase();
		this.drugType = drugType;
		this.usedRefills = 0;

	}

	public int calcMaximumRefills()
	{

		if (this.drugType.equalsIgnoreCase("Vaccine"))
		{
			this.maxRefills = 0;
		} else if (this.drugType.equalsIgnoreCase("Antibiotic"))
		{
			this.maxRefills = 3;
		} else if (this.drugType.equalsIgnoreCase("Vitamin Supplement"))
		{
			this.maxRefills = 6;
		} else
		{
			this.maxRefills = 0;
		}
		return this.maxRefills;
	}

	public int getNumberRx()
	{
		return numberRx;
	}

	public void setNumberRx(int numberRx)
	{
		this.numberRx = numberRx;
	}

	public String getPharmacyBranch()
	{
		return pharmacyBranch;
	}

	public void setPharmacyBranch(String pharmacyBranch)
	{
		this.pharmacyBranch = pharmacyBranch;
	}

	public String getDrugName()
	{
		return drugName;
	}

	public void setDrugName(String drugName)
	{
		this.drugName = drugName;
	}

	public String getDrugType()
	{
		return drugType;
	}

	public void setDrugType(String drugType)
	{
		this.drugType = drugType;
	}

	public int getMaxRefills()
	{
		return maxRefills;
	}

	public void setMaxRefills(int maxRefills)
	{
		this.maxRefills = maxRefills;
	}

	public int getUsedRefills()
	{
		return usedRefills;
	}

	public void setUsedRefills(int usedRefills)
	{
		this.usedRefills = usedRefills;
	}

	public boolean refill()
	{
		if (eligibleRefills > 0)
		{
			++usedRefills;
			return true;
		} else
		{
			return false;
		}
	}

	public int getRefillsAvailable()
	{

		int refills = calcMaximumRefills() - usedRefills;
		++usedRefills;
		if (refills >= 0)
		{
			refills = refills;
		} else
		{
			refills = 0;
		}
		return refills;
	}

	@Override
	public String toString()
	{
		return "PrescriptionOrder [numberRx=" + numberRx + ", pharmacyBranch=" + pharmacyBranch + ", drugName="
				+ drugName + " " + getRefillsAvailable() + " remaining refills";
	}

}
