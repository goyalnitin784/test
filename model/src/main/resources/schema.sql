-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 12, 2019 at 08:39 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `the420club`
--

-- --------------------------------------------------------

--
-- Table structure for table `ask_community_answers`
--

CREATE TABLE `ask_community_answers` (
  `id` int(11) NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `created_on` datetime NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `Dispensary_id` int(11) DEFAULT NULL,
  `Strain_Id` int(11) DEFAULT NULL,
  `Question_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `Total_Number_Of_likes` int(11) DEFAULT NULL,
  `Total_number_followed` int(11) DEFAULT NULL,
  `answer` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ask_community_questions`
--

CREATE TABLE `ask_community_questions` (
  `id` int(11) NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `created_on` datetime NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `Dispensary_id` int(11) DEFAULT NULL,
  `Strain_Id` int(11) DEFAULT NULL,
  `Question` varchar(2000) NOT NULL,
  `user_id` int(11) NOT NULL,
  `Total_Number_Of_likes` int(11) DEFAULT NULL,
  `Total_number_followed` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `business_user`
--

CREATE TABLE `business_user` (
  `id` int(11) NOT NULL,
  `created_on` datetime NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `Type_Of_user` int(11) NOT NULL DEFAULT '0',
  `usrname` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `profile_pic` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `Dispensary_id` int(11) NOT NULL DEFAULT '0',
  `confirmed_on` date NOT NULL,
  `dob` varchar(20) NOT NULL,
  `email_address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `contact_us`
--

CREATE TABLE `contact_us` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `question` varchar(2000) NOT NULL,
  `Name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `deal_review`
--

CREATE TABLE `deal_review` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
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
  `reviewed_on` datetime NOT NULL,
  `count_of_followers` int(11) DEFAULT NULL,
  `deal_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dispensary`
--

CREATE TABLE `dispensary` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
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
  `No_of_followers_count` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dispensary_deals`
--

CREATE TABLE `dispensary_deals` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
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
  `no_of_followers_count` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dispensary_followers`
--

CREATE TABLE `dispensary_followers` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `Dispensary_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `followed_on` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dispensary_gallery`
--

CREATE TABLE `dispensary_gallery` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `Dispensary_Id` int(11) NOT NULL,
  `picture_path` varchar(200) NOT NULL,
  `added_on` date NOT NULL,
  `is_active` int(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dispensary_menu`
--

CREATE TABLE `dispensary_menu` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
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
  `breeder` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dispensary_menu_price`
--

CREATE TABLE `dispensary_menu_price` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `Dispensary_menu_id` int(11) NOT NULL,
  `product_price` varchar(50) DEFAULT NULL,
  `quantity` varchar(100) DEFAULT NULL,
  `currency` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dispensary_pick_up_order`
--

CREATE TABLE `dispensary_pick_up_order` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
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
  `total_cost` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dispensary_pick_up_order_details`
--

CREATE TABLE `dispensary_pick_up_order_details` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `Dispensary_pick_up_order_Id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `strain_name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dispensary_review`
--

CREATE TABLE `dispensary_review` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
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
  `reviewed_on` datetime NOT NULL,
  `count_of_followers` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dispensary_updates`
--

CREATE TABLE `dispensary_updates` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `Dispensary_id` int(11) NOT NULL,
  `Update_Details` varchar(2000) NOT NULL,
  `Updated_on` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `newsletter_subscription`
--

CREATE TABLE `newsletter_subscription` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Subscribed` int(1) NOT NULL DEFAULT '1',
  `Subscribed_on` datetime NOT NULL,
  `Unsubscribe_on` datetime NOT NULL,
  `Unsubscription_Reason` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `products_category_type`
--

CREATE TABLE `products_category_type` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `product_category` varchar(100) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `image` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `quote_dispensary_response`
--

CREATE TABLE `quote_dispensary_response` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `Quote_Request_sent_to_Id` int(11) NOT NULL,
  `price_valid_till` varchar(200) NOT NULL,
  `Strain_Details` varchar(2000) NOT NULL,
  `user_rating` int(1) NOT NULL,
  `Special_Comments` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `quote_request`
--

CREATE TABLE `quote_request` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `user_id` int(11) NOT NULL,
  `requested_on` datetime NOT NULL,
  `strain_details` varchar(2000) NOT NULL,
  `location` varchar(2000) NOT NULL,
  `quantity` varchar(200) NOT NULL,
  `comments` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `quote_request_sent_to`
--

CREATE TABLE `quote_request_sent_to` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `Quote_Request_ID` int(11) NOT NULL,
  `Dispensary_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `strain`
--

CREATE TABLE `strain` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
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
  `short_description` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `strain_category_type`
--

CREATE TABLE `strain_category_type` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `Strain_Category_Type` varchar(100) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `image` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `strain_disease`
--

CREATE TABLE `strain_disease` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `Strain_id` int(11) NOT NULL,
  `Strain_Diease_Cure Master_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `strain_disease_cure_master`
--

CREATE TABLE `strain_disease_cure_master` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `disease` varchar(200) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `image` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `strain_effects`
--

CREATE TABLE `strain_effects` (
  `Id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `Strain_id` int(11) NOT NULL,
  `Strain_Effects_Master_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `strain_effects_master`
--

CREATE TABLE `strain_effects_master` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `Effects` varchar(2000) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `image` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `strain_flavours`
--

CREATE TABLE `strain_flavours` (
  `Id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `Strain_id` int(11) NOT NULL,
  `Strain_Flavour_Master_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `strain_flavour_master`
--

CREATE TABLE `strain_flavour_master` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `Flavour` varchar(2000) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `image` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `strain_gallery`
--

CREATE TABLE `strain_gallery` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `image` varchar(200) NOT NULL,
  `is_active` int(1) NOT NULL,
  `strain_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `strain_review`
--

CREATE TABLE `strain_review` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
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
  `reviewed_on` datetime NOT NULL,
  `acquired_from` varchar(2000) NOT NULL,
  `count_of_follower` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `strain_spec_misc_details`
--

CREATE TABLE `strain_spec_misc_details` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `Strain_Id` int(11) NOT NULL,
  `Variation` varchar(200) NOT NULL,
  `Difficulty` varchar(200) NOT NULL,
  `Flower_Period` varchar(2000) DEFAULT NULL,
  `Grow_Height` varchar(2000) DEFAULT NULL,
  `Grow_Yield` varchar(2000) DEFAULT NULL,
  `Environment` varchar(2000) DEFAULT NULL,
  `Breeder` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `testimonials`
--

CREATE TABLE `testimonials` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `Description` varchar(2000) NOT NULL,
  `isActive` int(11) NOT NULL DEFAULT '0',
  `User_Id` int(11) NOT NULL,
  `Updated_On` int(11) NOT NULL,
  `Display_On_Home_page` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `twitter_feeds`
--

CREATE TABLE `twitter_feeds` (
  `id` int(11) NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `created_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `Downloaded_On` datetime NOT NULL,
  `is_active` int(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `created_on` datetime NOT NULL,
  `last_updated_on` datetime NOT NULL,
  `uuid` varchar(50) NOT NULL,
  `Type_Of_user` int(11) NOT NULL DEFAULT '0',
  `usrname` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `profile_pic` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `is_age_above_21` int(11) NOT NULL DEFAULT '0',
  `confirmed_on` date NOT NULL,
  `dob` varchar(20) NOT NULL,
  `email_address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ask_community_answers`
--
ALTER TABLE `ask_community_answers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `ask_community_questions`
--
ALTER TABLE `ask_community_questions`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `business_user`
--
ALTER TABLE `business_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `contact_us`
--
ALTER TABLE `contact_us`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `deal_review`
--
ALTER TABLE `deal_review`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `dispensary`
--
ALTER TABLE `dispensary`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `dispensary_deals`
--
ALTER TABLE `dispensary_deals`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `dispensary_followers`
--
ALTER TABLE `dispensary_followers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `dispensary_gallery`
--
ALTER TABLE `dispensary_gallery`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `dispensary_menu`
--
ALTER TABLE `dispensary_menu`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `dispensary_menu_price`
--
ALTER TABLE `dispensary_menu_price`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `dispensary_pick_up_order`
--
ALTER TABLE `dispensary_pick_up_order`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `dispensary_pick_up_order_details`
--
ALTER TABLE `dispensary_pick_up_order_details`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `dispensary_review`
--
ALTER TABLE `dispensary_review`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `dispensary_updates`
--
ALTER TABLE `dispensary_updates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `newsletter_subscription`
--
ALTER TABLE `newsletter_subscription`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `products_category_type`
--
ALTER TABLE `products_category_type`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `quote_dispensary_response`
--
ALTER TABLE `quote_dispensary_response`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `quote_request`
--
ALTER TABLE `quote_request`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `quote_request_sent_to`
--
ALTER TABLE `quote_request_sent_to`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `strain`
--
ALTER TABLE `strain`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `strain_category_type`
--
ALTER TABLE `strain_category_type`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `strain_disease`
--
ALTER TABLE `strain_disease`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `strain_disease_cure_master`
--
ALTER TABLE `strain_disease_cure_master`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `strain_effects`
--
ALTER TABLE `strain_effects`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `strain_effects_master`
--
ALTER TABLE `strain_effects_master`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `strain_flavours`
--
ALTER TABLE `strain_flavours`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `strain_flavour_master`
--
ALTER TABLE `strain_flavour_master`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `strain_gallery`
--
ALTER TABLE `strain_gallery`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `strain_review`
--
ALTER TABLE `strain_review`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `strain_spec_misc_details`
--
ALTER TABLE `strain_spec_misc_details`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `testimonials`
--
ALTER TABLE `testimonials`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`),
  ADD KEY `User_Id` (`User_Id`),
  ADD KEY `User_Id_2` (`User_Id`),
  ADD KEY `User_Id_3` (`User_Id`),
  ADD KEY `User_Id_4` (`User_Id`);

--
-- Indexes for table `twitter_feeds`
--
ALTER TABLE `twitter_feeds`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid` (`uuid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ask_community_answers`
--
ALTER TABLE `ask_community_answers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `ask_community_questions`
--
ALTER TABLE `ask_community_questions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `contact_us`
--
ALTER TABLE `contact_us`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `deal_review`
--
ALTER TABLE `deal_review`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `dispensary`
--
ALTER TABLE `dispensary`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `dispensary_deals`
--
ALTER TABLE `dispensary_deals`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `dispensary_followers`
--
ALTER TABLE `dispensary_followers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `dispensary_gallery`
--
ALTER TABLE `dispensary_gallery`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `dispensary_menu`
--
ALTER TABLE `dispensary_menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `dispensary_menu_price`
--
ALTER TABLE `dispensary_menu_price`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `dispensary_pick_up_order`
--
ALTER TABLE `dispensary_pick_up_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `dispensary_pick_up_order_details`
--
ALTER TABLE `dispensary_pick_up_order_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `dispensary_review`
--
ALTER TABLE `dispensary_review`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `dispensary_updates`
--
ALTER TABLE `dispensary_updates`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `newsletter_subscription`
--
ALTER TABLE `newsletter_subscription`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `products_category_type`
--
ALTER TABLE `products_category_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `quote_dispensary_response`
--
ALTER TABLE `quote_dispensary_response`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `quote_request`
--
ALTER TABLE `quote_request`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `quote_request_sent_to`
--
ALTER TABLE `quote_request_sent_to`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `strain`
--
ALTER TABLE `strain`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `strain_category_type`
--
ALTER TABLE `strain_category_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `strain_disease`
--
ALTER TABLE `strain_disease`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `strain_effects`
--
ALTER TABLE `strain_effects`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `strain_effects_master`
--
ALTER TABLE `strain_effects_master`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `strain_flavours`
--
ALTER TABLE `strain_flavours`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `strain_flavour_master`
--
ALTER TABLE `strain_flavour_master`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `strain_gallery`
--
ALTER TABLE `strain_gallery`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `strain_review`
--
ALTER TABLE `strain_review`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `twitter_feeds`
--
ALTER TABLE `twitter_feeds`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
