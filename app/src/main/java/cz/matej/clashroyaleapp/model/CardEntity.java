package cz.matej.clashroyaleapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


/**
 * Created by Fanda on 4.4.2017.
 */

public class CardEntity implements Serializable
{
	@SerializedName("_id")

	private String id;
	@SerializedName("idName")

	private String idName;
	@SerializedName("rarity")

	private String rarity;
	@SerializedName("type")

	private String type;
	@SerializedName("name")

	private String name;
	@SerializedName("description")

	private String description;
	@SerializedName("arena")

	private Integer arena;
	@SerializedName("elixirCost")

	private Integer elixirCost;
	@SerializedName("order")

	private Integer order;
	@SerializedName("__v")

	private Integer v;


	public String getId()
	{
		return id;
	}


	public void setId(String id)
	{
		this.id = id;
	}


	public String getIdName()
	{
		return idName;
	}


	public void setIdName(String idName)
	{
		this.idName = idName;
	}


	public String getRarity()
	{
		return rarity;
	}


	public void setRarity(String rarity)
	{
		this.rarity = rarity;
	}


	public String getType()
	{
		return type;
	}


	public void setType(String type)
	{
		this.type = type;
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public String getDescription()
	{
		return description;
	}


	public void setDescription(String description)
	{
		this.description = description;
	}


	public Integer getArena()
	{
		return arena;
	}


	public void setArena(Integer arena)
	{
		this.arena = arena;
	}


	public Integer getElixirCost()
	{
		return elixirCost;
	}


	public void setElixirCost(Integer elixirCost)
	{
		this.elixirCost = elixirCost;
	}


	public Integer getOrder()
	{
		return order;
	}


	public void setOrder(Integer order)
	{
		this.order = order;
	}


	public Integer getV()
	{
		return v;
	}


	public void setV(Integer v)
	{
		this.v = v;
	}

}
