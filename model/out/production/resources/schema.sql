-- MySQL dump 10.13  Distrib 5.6.37, for macos10.12 (x86_64)
--
-- Host: localhost    Database: the420club
-- ------------------------------------------------------
-- Server version	5.6.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `the420club`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `the420club` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `the420club`;

--
-- Table structure for table `ask_community_answers`
--

DROP TABLE IF EXISTS `ask_community_answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ask_community_answers` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(50) NOT NULL,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Dispensary_id` int(11) DEFAULT NULL,
  `Strain_Id` int(11) DEFAULT NULL,
  `Question_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `Total_Number_Of_likes` int(11) DEFAULT NULL,
  `Total_number_followed` int(11) DEFAULT NULL,
  `answer` varchar(2000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ask_community_answers`
--

LOCK TABLES `ask_community_answers` WRITE;
/*!40000 ALTER TABLE `ask_community_answers` DISABLE KEYS */;
/*!40000 ALTER TABLE `ask_community_answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ask_community_questions`
--

DROP TABLE IF EXISTS `ask_community_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ask_community_questions` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(50) NOT NULL,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Dispensary_id` int(11) DEFAULT NULL,
  `Strain_Id` int(11) DEFAULT NULL,
  `Question` varchar(2000) NOT NULL,
  `user_id` int(11) NOT NULL,
  `Total_Number_Of_likes` int(11) DEFAULT NULL,
  `Total_number_followed` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ask_community_questions`
--

LOCK TABLES `ask_community_questions` WRITE;
/*!40000 ALTER TABLE `ask_community_questions` DISABLE KEYS */;
/*!40000 ALTER TABLE `ask_community_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `business_user`
--

DROP TABLE IF EXISTS `business_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `business_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Type_Of_user` int(11) NOT NULL DEFAULT '0',
  `usrname` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `profile_pic` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `Dispensary_id` int(11) NOT NULL DEFAULT '0',
  `confirmed_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `dob` varchar(20) NOT NULL,
  `email_address` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `business_user`
--

LOCK TABLES `business_user` WRITE;
/*!40000 ALTER TABLE `business_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `business_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_us`
--

DROP TABLE IF EXISTS `contact_us`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact_us` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `question` varchar(2000) NOT NULL,
  `Name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_us`
--

LOCK TABLES `contact_us` WRITE;
/*!40000 ALTER TABLE `contact_us` DISABLE KEYS */;
/*!40000 ALTER TABLE `contact_us` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deal_review`
--

DROP TABLE IF EXISTS `deal_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deal_review` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `dispensary_id` int(11) NOT NULL,
  `Reviewer_User_id` int(11) NOT NULL,
  `deal_correctness_Rating` int(1) NOT NULL,
  `value_for_money_Rating` int(1) NOT NULL,
  `overall_quality_rating` int(1) NOT NULL,
  `Recommendation_Count` int(11) DEFAULT NULL,
  `is_review_Helpful_count` int(11) NOT NULL,
  `Number_Of_Shares_Count` int(11) NOT NULL,
  `make_review_private` int(1) DEFAULT NULL,
  `is_active` int(11) NOT NULL DEFAULT '0',
  `review Description` varchar(2000) NOT NULL,
  `recommend_for_future` int(11) DEFAULT NULL,
  `reviewed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `count_of_followers` int(11) DEFAULT NULL,
  `deal_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deal_review`
--

LOCK TABLES `deal_review` WRITE;
/*!40000 ALTER TABLE `deal_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `deal_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dispensary`
--

DROP TABLE IF EXISTS `dispensary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dispensary` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Dispensary_Name` varchar(200) NOT NULL,
  `Dispensary_Profile_pic` varchar(200) DEFAULT NULL,
  `Dispensary_Desc` varchar(2000) NOT NULL,
  `phone` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `website` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `city` varchar(200) DEFAULT NULL,
  `state` varchar(100) NOT NULL,
  `country` varchar(100) NOT NULL,
  `facilities` varchar(200) NOT NULL,
  `longitude` varchar(200) NOT NULL,
  `lattitude` varchar(200) NOT NULL,
  `timezone` varchar(100) NOT NULL,
  `monday_open_on` varchar(200) DEFAULT NULL,
  `monday_close_on` varchar(200) DEFAULT NULL,
  `tuesday_open_on` varchar(200) DEFAULT NULL,
  `tuesday_close_on` varchar(200) DEFAULT NULL,
  `wednesday_open_on` varchar(200) DEFAULT NULL,
  `wednesday_close_on` varchar(200) DEFAULT NULL,
  `thursday_open_on` varchar(200) DEFAULT NULL,
  `thursday_cose_on` varchar(200) DEFAULT NULL,
  `friday_open_on` int(200) DEFAULT NULL,
  `friday_close_on` int(200) DEFAULT NULL,
  `Saturday_open_on` int(200) DEFAULT NULL,
  `Saturday_close_on` int(200) DEFAULT NULL,
  `sunday_open_on` int(200) DEFAULT NULL,
  `sunday_close_on` int(200) DEFAULT NULL,
  `is_trending_disp` int(1) DEFAULT NULL,
  `isFeaturedDispensary` int(1) DEFAULT NULL,
  `Date_of_Joining` datetime DEFAULT NULL,
  `Is_verified_Listing` int(1) DEFAULT NULL,
  `is_active` int(1) DEFAULT NULL,
  `No_of_followers_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dispensary`
--

LOCK TABLES `dispensary` WRITE;
/*!40000 ALTER TABLE `dispensary` DISABLE KEYS */;
/*!40000 ALTER TABLE `dispensary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dispensary_deals`
--

DROP TABLE IF EXISTS `dispensary_deals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dispensary_deals` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Dispensary_id` int(11) NOT NULL,
  `Deal_Name` varchar(2000) NOT NULL,
  `Deal_Description` varchar(2000) NOT NULL,
  `validity_begin` date DEFAULT NULL,
  `validity_end` date DEFAULT NULL,
  `deal_tag_line` varchar(500) DEFAULT NULL,
  `voucher_code` varchar(100) DEFAULT NULL,
  `discount_percentage` varchar(100) DEFAULT NULL,
  `deal_image_1` varchar(200) DEFAULT NULL,
  `deal_image_2` varchar(200) DEFAULT NULL,
  `istrendingdeal` int(1) DEFAULT NULL,
  `isfeatureddeal` int(1) DEFAULT NULL,
  `isActive` int(1) NOT NULL,
  `price` varchar(200) DEFAULT NULL,
  `special_comments` varchar(2000) DEFAULT NULL,
  `no_of_followers_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dispensary_deals`
--

LOCK TABLES `dispensary_deals` WRITE;
/*!40000 ALTER TABLE `dispensary_deals` DISABLE KEYS */;
/*!40000 ALTER TABLE `dispensary_deals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dispensary_followers`
--

DROP TABLE IF EXISTS `dispensary_followers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dispensary_followers` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Dispensary_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `followed_on` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dispensary_followers`
--

LOCK TABLES `dispensary_followers` WRITE;
/*!40000 ALTER TABLE `dispensary_followers` DISABLE KEYS */;
/*!40000 ALTER TABLE `dispensary_followers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dispensary_gallery`
--

DROP TABLE IF EXISTS `dispensary_gallery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dispensary_gallery` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Dispensary_Id` int(11) NOT NULL,
  `picture_path` varchar(200) NOT NULL,
  `added_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `is_active` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dispensary_gallery`
--

LOCK TABLES `dispensary_gallery` WRITE;
/*!40000 ALTER TABLE `dispensary_gallery` DISABLE KEYS */;
/*!40000 ALTER TABLE `dispensary_gallery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dispensary_menu`
--

DROP TABLE IF EXISTS `dispensary_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dispensary_menu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Dispensary_id` int(11) NOT NULL,
  `Product Name` varchar(200) NOT NULL,
  `Product_Category_Type_id` int(11) NOT NULL,
  `Strain_Category_Type_id` int(11) NOT NULL,
  `Description` varchar(2000) NOT NULL,
  `image1` varchar(50) NOT NULL,
  `image2` varchar(50) NOT NULL,
  `image3` varchar(50) DEFAULT NULL,
  `CBD_Level` varchar(100) DEFAULT NULL,
  `THC_Level` varchar(100) DEFAULT NULL,
  `other_details` varchar(2000) DEFAULT NULL,
  `strain_id` int(11) DEFAULT NULL,
  `breeder` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dispensary_menu`
--

LOCK TABLES `dispensary_menu` WRITE;
/*!40000 ALTER TABLE `dispensary_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `dispensary_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dispensary_menu_price`
--

DROP TABLE IF EXISTS `dispensary_menu_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dispensary_menu_price` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Dispensary_menu_id` int(11) NOT NULL,
  `product_price` varchar(50) DEFAULT NULL,
  `quantity` varchar(100) DEFAULT NULL,
  `currency` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dispensary_menu_price`
--

LOCK TABLES `dispensary_menu_price` WRITE;
/*!40000 ALTER TABLE `dispensary_menu_price` DISABLE KEYS */;
/*!40000 ALTER TABLE `dispensary_menu_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dispensary_pick_up_order`
--

DROP TABLE IF EXISTS `dispensary_pick_up_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dispensary_pick_up_order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Dispensary_id` int(11) NOT NULL,
  `Dispensary_pick_up_order_code` varchar(200) NOT NULL,
  `User_id` int(11) NOT NULL,
  `Pick_up_Date` date DEFAULT NULL,
  `Pick_up_time_slot` varchar(200) DEFAULT NULL,
  `special_comments` varchar(2000) DEFAULT NULL,
  `pick_up_order_status` varchar(100) DEFAULT NULL,
  `pick_up_requested_on` date DEFAULT NULL,
  `picked_up_by` varchar(2000) DEFAULT NULL,
  `pick_up_picked_on` datetime DEFAULT NULL,
  `total_cost` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dispensary_pick_up_order`
--

LOCK TABLES `dispensary_pick_up_order` WRITE;
/*!40000 ALTER TABLE `dispensary_pick_up_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `dispensary_pick_up_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dispensary_pick_up_order_details`
--

DROP TABLE IF EXISTS `dispensary_pick_up_order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dispensary_pick_up_order_details` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Dispensary_pick_up_order_Id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `strain_name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dispensary_pick_up_order_details`
--

LOCK TABLES `dispensary_pick_up_order_details` WRITE;
/*!40000 ALTER TABLE `dispensary_pick_up_order_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `dispensary_pick_up_order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dispensary_review`
--

DROP TABLE IF EXISTS `dispensary_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dispensary_review` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `dispensary_id` int(11) NOT NULL,
  `Reviewer_User_id` int(11) NOT NULL,
  `Quality_Rating` int(1) NOT NULL,
  `overall_quality_rating` int(11) DEFAULT NULL,
  `Service_Rating` int(1) NOT NULL,
  `Atmosphere_Rating` int(1) NOT NULL,
  `Recommendation_Count` int(11) NOT NULL,
  `is_review_Helpful_count` int(11) NOT NULL,
  `Number_Of_Shares_Count` int(11) NOT NULL,
  `make_review_private` int(1) DEFAULT NULL,
  `is_active` int(11) NOT NULL DEFAULT '0',
  `review Description` varchar(2000) NOT NULL,
  `reviewed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `count_of_followers` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dispensary_review`
--

LOCK TABLES `dispensary_review` WRITE;
/*!40000 ALTER TABLE `dispensary_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `dispensary_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dispensary_updates`
--

DROP TABLE IF EXISTS `dispensary_updates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dispensary_updates` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Dispensary_id` int(11) NOT NULL,
  `Update_Details` varchar(2000) NOT NULL,
  `Updated_on` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dispensary_updates`
--

LOCK TABLES `dispensary_updates` WRITE;
/*!40000 ALTER TABLE `dispensary_updates` DISABLE KEYS */;
/*!40000 ALTER TABLE `dispensary_updates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `newsletter_subscription`
--

DROP TABLE IF EXISTS `newsletter_subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `newsletter_subscription` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Subscribed` int(1) NOT NULL DEFAULT '1',
  `Subscribed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Unsubscribe_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Unsubscription_Reason` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `newsletter_subscription`
--

LOCK TABLES `newsletter_subscription` WRITE;
/*!40000 ALTER TABLE `newsletter_subscription` DISABLE KEYS */;
/*!40000 ALTER TABLE `newsletter_subscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products_category_type`
--

DROP TABLE IF EXISTS `products_category_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products_category_type` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `product_category` varchar(100) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `image` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products_category_type`
--

LOCK TABLES `products_category_type` WRITE;
/*!40000 ALTER TABLE `products_category_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `products_category_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quote_dispensary_response`
--

DROP TABLE IF EXISTS `quote_dispensary_response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quote_dispensary_response` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Quote_Request_sent_to_Id` int(11) NOT NULL,
  `price_valid_till` varchar(200) NOT NULL,
  `Strain_Details` varchar(2000) NOT NULL,
  `user_rating` int(1) NOT NULL,
  `Special_Comments` varchar(2000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quote_dispensary_response`
--

LOCK TABLES `quote_dispensary_response` WRITE;
/*!40000 ALTER TABLE `quote_dispensary_response` DISABLE KEYS */;
/*!40000 ALTER TABLE `quote_dispensary_response` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quote_request`
--

DROP TABLE IF EXISTS `quote_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quote_request` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `user_id` int(11) NOT NULL,
  `requested_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `strain_details` varchar(2000) NOT NULL,
  `location` varchar(2000) NOT NULL,
  `quantity` varchar(200) NOT NULL,
  `comments` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quote_request`
--

LOCK TABLES `quote_request` WRITE;
/*!40000 ALTER TABLE `quote_request` DISABLE KEYS */;
/*!40000 ALTER TABLE `quote_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quote_request_sent_to`
--

DROP TABLE IF EXISTS `quote_request_sent_to`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quote_request_sent_to` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Quote_Request_ID` int(11) NOT NULL,
  `Dispensary_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quote_request_sent_to`
--

LOCK TABLES `quote_request_sent_to` WRITE;
/*!40000 ALTER TABLE `quote_request_sent_to` DISABLE KEYS */;
/*!40000 ALTER TABLE `quote_request_sent_to` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `strain`
--

DROP TABLE IF EXISTS `strain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `strain` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `is_Trending_Strain` int(1) NOT NULL,
  `Strain_Name` varchar(200) NOT NULL,
  `Product_Category_Type_id` int(11) NOT NULL,
  `Strain_Category_Type_id` int(11) NOT NULL,
  `Description` varchar(2000) NOT NULL,
  `image1` varchar(50) NOT NULL,
  `image2` varchar(50) NOT NULL,
  `image3` varchar(50) DEFAULT NULL,
  `CBD_Level` varchar(100) DEFAULT NULL,
  `THC_Level` varchar(100) DEFAULT NULL,
  `other_details` varchar(2000) DEFAULT NULL,
  `is_featured_strain` int(1) DEFAULT NULL,
  `breeder` varchar(50) DEFAULT NULL,
  `origin_details` varchar(2000) DEFAULT NULL,
  `origin_image` int(11) DEFAULT NULL,
  `short_description` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strain`
--

LOCK TABLES `strain` WRITE;
/*!40000 ALTER TABLE `strain` DISABLE KEYS */;
/*!40000 ALTER TABLE `strain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `strain_category_type`
--

DROP TABLE IF EXISTS `strain_category_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `strain_category_type` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Strain_Category_Type` varchar(100) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `image` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strain_category_type`
--

LOCK TABLES `strain_category_type` WRITE;
/*!40000 ALTER TABLE `strain_category_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `strain_category_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `strain_disease`
--

DROP TABLE IF EXISTS `strain_disease`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `strain_disease` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Strain_id` int(11) NOT NULL,
  `Strain_Diease_Cure Master_Id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strain_disease`
--

LOCK TABLES `strain_disease` WRITE;
/*!40000 ALTER TABLE `strain_disease` DISABLE KEYS */;
/*!40000 ALTER TABLE `strain_disease` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `strain_disease_cure_master`
--

DROP TABLE IF EXISTS `strain_disease_cure_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `strain_disease_cure_master` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `disease` varchar(200) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `image` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strain_disease_cure_master`
--

LOCK TABLES `strain_disease_cure_master` WRITE;
/*!40000 ALTER TABLE `strain_disease_cure_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `strain_disease_cure_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `strain_effects`
--

DROP TABLE IF EXISTS `strain_effects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `strain_effects` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Strain_id` int(11) NOT NULL,
  `Strain_Effects_Master_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strain_effects`
--

LOCK TABLES `strain_effects` WRITE;
/*!40000 ALTER TABLE `strain_effects` DISABLE KEYS */;
/*!40000 ALTER TABLE `strain_effects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `strain_effects_master`
--

DROP TABLE IF EXISTS `strain_effects_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `strain_effects_master` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Effects` varchar(2000) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `image` varchar(2000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strain_effects_master`
--

LOCK TABLES `strain_effects_master` WRITE;
/*!40000 ALTER TABLE `strain_effects_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `strain_effects_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `strain_flavour_master`
--

DROP TABLE IF EXISTS `strain_flavour_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `strain_flavour_master` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Flavour` varchar(2000) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `image` varchar(2000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strain_flavour_master`
--

LOCK TABLES `strain_flavour_master` WRITE;
/*!40000 ALTER TABLE `strain_flavour_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `strain_flavour_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `strain_flavours`
--

DROP TABLE IF EXISTS `strain_flavours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `strain_flavours` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Strain_id` int(11) NOT NULL,
  `Strain_Flavour_Master_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strain_flavours`
--

LOCK TABLES `strain_flavours` WRITE;
/*!40000 ALTER TABLE `strain_flavours` DISABLE KEYS */;
/*!40000 ALTER TABLE `strain_flavours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `strain_gallery`
--

DROP TABLE IF EXISTS `strain_gallery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `strain_gallery` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `image` varchar(200) NOT NULL,
  `is_active` int(1) NOT NULL,
  `strain_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strain_gallery`
--

LOCK TABLES `strain_gallery` WRITE;
/*!40000 ALTER TABLE `strain_gallery` DISABLE KEYS */;
/*!40000 ALTER TABLE `strain_gallery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `strain_review`
--

DROP TABLE IF EXISTS `strain_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `strain_review` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `strain_id` int(11) NOT NULL,
  `Reviewer_User_id` int(11) NOT NULL,
  `Recommendation_Count` int(11) NOT NULL,
  `is_review_Helpful_count` int(11) NOT NULL,
  `Number_Of_Shares_Count` int(11) NOT NULL,
  `make_review_private` int(1) DEFAULT NULL,
  `is_active` int(11) NOT NULL DEFAULT '0',
  `review Description` varchar(2000) NOT NULL,
  `Consumption_form` varchar(2000) DEFAULT NULL,
  `Consumption_Method` varchar(2000) DEFAULT NULL,
  `Effects_information` varchar(2000) DEFAULT NULL,
  `medical_conditions` varchar(2000) DEFAULT NULL,
  `disease_condition` varchar(2000) DEFAULT NULL,
  `THC_percentage` varchar(200) DEFAULT NULL,
  `reviewed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `acquired_from` varchar(2000) NOT NULL,
  `count_of_follower` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strain_review`
--

LOCK TABLES `strain_review` WRITE;
/*!40000 ALTER TABLE `strain_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `strain_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `strain_spec_misc_details`
--

DROP TABLE IF EXISTS `strain_spec_misc_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `strain_spec_misc_details` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Strain_Id` int(11) NOT NULL,
  `Variation` varchar(200) NOT NULL,
  `Difficulty` varchar(200) NOT NULL,
  `Flower_Period` varchar(2000) DEFAULT NULL,
  `Grow_Height` varchar(2000) DEFAULT NULL,
  `Grow_Yield` varchar(2000) DEFAULT NULL,
  `Environment` varchar(2000) DEFAULT NULL,
  `Breeder` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strain_spec_misc_details`
--

LOCK TABLES `strain_spec_misc_details` WRITE;
/*!40000 ALTER TABLE `strain_spec_misc_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `strain_spec_misc_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testimonials`
--

DROP TABLE IF EXISTS `testimonials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `testimonials` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Description` varchar(2000) NOT NULL,
  `isActive` int(11) NOT NULL DEFAULT '0',
  `User_Id` int(11) NOT NULL,
  `Updated_On` int(11) NOT NULL,
  `Display_On_Home_page` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testimonials`
--

LOCK TABLES `testimonials` WRITE;
/*!40000 ALTER TABLE `testimonials` DISABLE KEYS */;
/*!40000 ALTER TABLE `testimonials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `twitter_feeds`
--

DROP TABLE IF EXISTS `twitter_feeds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `twitter_feeds` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `Downloaded_On` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_active` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `twitter_feeds`
--

LOCK TABLES `twitter_feeds` WRITE;
/*!40000 ALTER TABLE `twitter_feeds` DISABLE KEYS */;
/*!40000 ALTER TABLE `twitter_feeds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_details` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` varchar(50) NOT NULL,
  `Type_Of_user` int(11) NOT NULL DEFAULT '0',
  `usrname` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `profile_pic` varchar(100) DEFAULT NULL,
  `phone` varchar(20) NOT NULL,
  `is_age_above_21` int(11) NOT NULL DEFAULT '0',
  `confirmed_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `dob` varchar(20) NOT NULL,
  `email_address` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_details`
--

LOCK TABLES `user_details` WRITE;
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-17 18:28:47
