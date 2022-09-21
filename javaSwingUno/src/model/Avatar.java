package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Avatar 
{
	private ImageIcon avatarIcon;
	
	//default avatar constructor
	public Avatar()
	{
		Icon icon = new ImageIcon(".\\resources\\Avatars\\default.png");
		this.avatarIcon = (ImageIcon) icon;
		avatarIcon.setDescription("default");
	}
	
	//avatar constructor within a pull of avatar icons
	public Avatar(int index)
	{
		this.avatarIcon = new ImageIcon(".\\resources\\Avatars\\" + "Avatar_" + index + ".png");
		this.avatarIcon.setDescription("Avatar_" + index);
	}
	
	public ImageIcon getAvatar()
	{
		return this.avatarIcon;
	}
	
	public Avatar getMaxLevelAvatar()
	{
		this.avatarIcon = new ImageIcon(".\\resources\\Avatars\\goldenAvatar.png");
		return this;
	}
	
	 @Override
	public String toString()
	{
		return this.getAvatar().getDescription();
	}
}

