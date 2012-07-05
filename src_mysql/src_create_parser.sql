
CREATE  TABLE IF NOT EXISTS `Contact` (
  `ContactID` INT NOT NULL ,
  `Name` VARCHAR(100) NULL ,
  `Surname` VARCHAR(100) NULL ,
  `Comments` TEXT NULL ,
  `_dateModified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  PRIMARY KEY (`ContactID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `Email` (
  `EmailID` INT NOT NULL ,
  `EmailAddress` VARCHAR(100) NULL ,
  `Comments` VARCHAR(200) NULL ,
  `_dateModified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  PRIMARY KEY (`EmailID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `Telephone` (
  `TelephoneID` INT NOT NULL ,
  `TelephoneNumber` VARCHAR(45) NULL ,
  `Comments` VARCHAR(200) NULL ,
  `_dateModified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  PRIMARY KEY (`TelephoneID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `ContactEmail` (
  `ContactEmailID` INT NOT NULL ,
  `ContactID` INT NOT NULL ,
  `EmailID` INT NOT NULL ,
  PRIMARY KEY (`ContactEmailID`) ,
  INDEX `fk_ContactEmail_ContactID` (`ContactID` ASC) ,
  INDEX `fk_ContactEmail_EmailID` (`EmailID` ASC) ,
  CONSTRAINT `fk_ContactEmail_ContactID`
    FOREIGN KEY (`ContactID` )
    REFERENCES `Contact` (`ContactID` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ContactEmail_EmailID`
    FOREIGN KEY (`EmailID` )
    REFERENCES `Email` (`EmailID` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `ContactTelephone` (
  `ContactTelephoneID` INT NOT NULL ,
  `ContactID` INT NOT NULL ,
  `TelephoneID` INT NOT NULL ,
  PRIMARY KEY (`ContactTelephoneID`) ,
  INDEX `fk_ContactTelephone_ContactID` (`ContactID` ASC) ,
  INDEX `fk_ContactTelephone_TelephoneID` (`TelephoneID` ASC) ,
  CONSTRAINT `fk_ContactTelephone_ContactID`
    FOREIGN KEY (`ContactID` )
    REFERENCES `Contact` (`ContactID` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ContactTelephone_TelephoneID`
    FOREIGN KEY (`TelephoneID` )
    REFERENCES `Telephone` (`TelephoneID` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `cGroup` (
  `cGroupID` INT NOT NULL ,
  `GroupName` VARCHAR(200) NULL ,
  `_dateModified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  PRIMARY KEY (`cGroupID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `ContactGroup` (
  `ContactGroupID` INT NOT NULL ,
  `ContactID` INT NOT NULL ,
  `GroupID` INT NOT NULL ,
  PRIMARY KEY (`ContactGroupID`) ,
  INDEX `fk_ContactGroup_Contact` (`ContactID` ASC) ,
  INDEX `fk_ContactGroup_Group` (`GroupID` ASC) ,
  CONSTRAINT `fk_ContactGroup_Contact`
    FOREIGN KEY (`ContactID` )
    REFERENCES `Contact` (`ContactID` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ContactGroup_Group`
    FOREIGN KEY (`GroupID` )
    REFERENCES `cGroup` (`cGroupID` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

