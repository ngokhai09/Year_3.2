﻿USE [QLCuaHangThucPham]
GO
/****** Object:  Table [dbo].[AnhSP]    Script Date: 3/25/2022 10:36:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AnhSP](
	[MaAnh] [nvarchar](15) NOT NULL,
	[MaSP] [nvarchar](15) NOT NULL,
	[TenAnh] [nvarchar](50) NULL,
	[URL] [nvarchar](50) NULL,
 CONSTRAINT [PK_AnhSP] PRIMARY KEY CLUSTERED 
(
	[MaAnh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTDH]    Script Date: 3/25/2022 10:36:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTDH](
	[MaDH] [nvarchar](15) NOT NULL,
	[MaSP] [nvarchar](15) NOT NULL,
	[SoLuong] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonHang]    Script Date: 3/25/2022 10:36:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonHang](
	[MaDH] [nvarchar](15) NOT NULL,
	[Time_Create] [datetime] NULL,
	[Money] [money] NULL,
	[HoTen] [nvarchar](50) NULL,
	[GioiTinh] [nvarchar](5) NULL,
	[Email] [nvarchar](50) NULL,
	[SDT] [nvarchar](10) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[Username] [nvarchar](15) NOT NULL,
 CONSTRAINT [PK_DonHang] PRIMARY KEY CLUSTERED 
(
	[MaDH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GiaSP]    Script Date: 3/25/2022 10:36:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GiaSP](
	[MaGia] [nvarchar](15) NOT NULL,
	[MaSP] [nvarchar](15) NULL,
	[Gia] [money] NULL,
	[Time_Begin] [datetime] NULL,
	[Time_End] [datetime] NULL,
 CONSTRAINT [PK_GiaSP] PRIMARY KEY CLUSTERED 
(
	[MaGia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 3/25/2022 10:36:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [nvarchar](15) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[GioiTinh] [nvarchar](5) NULL,
	[Tuoi] [int] NULL,
	[Email] [nvarchar](50) NULL,
	[SDT] [nvarchar](10) NULL,
	[Time_Create] [datetime] NULL,
	[Time_Update] [datetime] NULL,
	[NguoiTao] [nvarchar](50) NULL,
	[isActive] [tinyint] NULL,
	[isDelete] [tinyint] NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiSP]    Script Date: 3/25/2022 10:36:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSP](
	[MaLoai] [nvarchar](15) NOT NULL,
	[TenLoai] [nvarchar](50) NULL,
	[Time_Create] [datetime] NULL,
	[Time_Update] [datetime] NULL,
	[NguoiTao] [nvarchar](50) NULL,
	[isActive] [tinyint] NULL,
	[isDelete] [tinyint] NULL,
 CONSTRAINT [PK_LoaiSP] PRIMARY KEY CLUSTERED 
(
	[MaLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiTT]    Script Date: 3/25/2022 10:36:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiTT](
	[MaLoaiTT] [nvarchar](15) NOT NULL,
	[TenLoai] [nvarchar](50) NULL,
	[Time_Create] [datetime] NULL,
	[Time_Update] [datetime] NULL,
	[NguoiTao] [nvarchar](50) NULL,
	[isActive] [tinyint] NULL,
 CONSTRAINT [PK_LoaiTT] PRIMARY KEY CLUSTERED 
(
	[MaLoaiTT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PTTT]    Script Date: 3/25/2022 10:36:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PTTT](
	[MaPTTT] [nvarchar](15) NOT NULL,
	[TenPT] [nvarchar](50) NULL,
	[Time_Create] [datetime] NULL,
	[Time_Update] [datetime] NULL,
	[NguoiTao] [nvarchar](50) NULL,
	[isActive] [tinyint] NULL,
	[isDelete] [tinyint] NULL,
 CONSTRAINT [PK_PTTT] PRIMARY KEY CLUSTERED 
(
	[MaPTTT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PTVC]    Script Date: 3/25/2022 10:36:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PTVC](
	[MaPTVC] [nvarchar](15) NOT NULL,
	[TenPT] [nvarchar](50) NULL,
	[Time_Create] [datetime] NULL,
	[Time_UpDate] [datetime] NULL,
	[isActive] [tinyint] NULL,
	[isDelete] [tinyint] NULL,
	[NguoiTao] [nvarchar](50) NULL,
 CONSTRAINT [PK_PTVC] PRIMARY KEY CLUSTERED 
(
	[MaPTVC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 3/25/2022 10:36:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSP] [nvarchar](15) NOT NULL,
	[TenSP] [nvarchar](50) NULL,
	[GTSP] [nvarchar](50) NULL,
	[MaLoai] [nvarchar](15) NULL,
	[SL] [int] NULL,
	[Time_Create] [datetime] NULL,
	[Time_Update] [datetime] NULL,
	[NguoiTao] [nvarchar](50) NULL,
	[isActive] [tinyint] NULL,
	[isDelete] [tinyint] NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 3/25/2022 10:36:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[MaKH] [nvarchar](15) NULL,
	[TaiKhoan] [nvarchar](50) NULL,
	[MatKhau] [nvarchar](50) NULL,
	[Admin] [tinyint] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TinTuc]    Script Date: 3/25/2022 10:36:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TinTuc](
	[MaTT] [nvarchar](15) NOT NULL,
	[MoTa] [nvarchar](50) NULL,
	[Anh] [nvarchar](50) NULL,
	[MaLoaiTT] [nvarchar](15) NULL,
	[ND] [nvarchar](max) NULL,
 CONSTRAINT [PK_TinTuc] PRIMARY KEY CLUSTERED 
(
	[MaTT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TTDH]    Script Date: 3/25/2022 10:36:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TTDH](
	[MaDH] [nvarchar](15) NOT NULL,
	[MaPTTT] [nvarchar](15) NOT NULL,
	[Tong] [money] NULL,
	[GhiChu] [nvarchar](100) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VCDH]    Script Date: 3/25/2022 10:36:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VCDH](
	[MaDH] [nvarchar](15) NOT NULL,
	[MaPTVC] [nvarchar](15) NOT NULL,
	[Tong] [money] NULL,
	[GhiChu] [nvarchar](50) NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[AnhSP]  WITH CHECK ADD  CONSTRAINT [FK_AnhSP_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[AnhSP] CHECK CONSTRAINT [FK_AnhSP_SanPham]
GO
ALTER TABLE [dbo].[CTDH]  WITH CHECK ADD  CONSTRAINT [FK_CTDH_DonHang] FOREIGN KEY([MaDH])
REFERENCES [dbo].[DonHang] ([MaDH])
GO
ALTER TABLE [dbo].[CTDH] CHECK CONSTRAINT [FK_CTDH_DonHang]
GO
ALTER TABLE [dbo].[CTDH]  WITH CHECK ADD  CONSTRAINT [FK_CTDH_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[CTDH] CHECK CONSTRAINT [FK_CTDH_SanPham]
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [FK_DonHang_KhachHang] FOREIGN KEY([Username])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[DonHang] CHECK CONSTRAINT [FK_DonHang_KhachHang]
GO
ALTER TABLE [dbo].[GiaSP]  WITH CHECK ADD  CONSTRAINT [FK_GiaSP_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[GiaSP] CHECK CONSTRAINT [FK_GiaSP_SanPham]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_LoaiSP] FOREIGN KEY([MaLoai])
REFERENCES [dbo].[LoaiSP] ([MaLoai])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_LoaiSP]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_KhachHang]
GO
ALTER TABLE [dbo].[TinTuc]  WITH CHECK ADD  CONSTRAINT [FK_TinTuc_LoaiTT] FOREIGN KEY([MaLoaiTT])
REFERENCES [dbo].[LoaiTT] ([MaLoaiTT])
GO
ALTER TABLE [dbo].[TinTuc] CHECK CONSTRAINT [FK_TinTuc_LoaiTT]
GO
ALTER TABLE [dbo].[TTDH]  WITH CHECK ADD  CONSTRAINT [FK_TTDH_DonHang] FOREIGN KEY([MaDH])
REFERENCES [dbo].[DonHang] ([MaDH])
GO
ALTER TABLE [dbo].[TTDH] CHECK CONSTRAINT [FK_TTDH_DonHang]
GO
ALTER TABLE [dbo].[TTDH]  WITH CHECK ADD  CONSTRAINT [FK_TTDH_PTTT] FOREIGN KEY([MaPTTT])
REFERENCES [dbo].[PTTT] ([MaPTTT])
GO
ALTER TABLE [dbo].[TTDH] CHECK CONSTRAINT [FK_TTDH_PTTT]
GO
ALTER TABLE [dbo].[VCDH]  WITH CHECK ADD  CONSTRAINT [FK_VCDH_DonHang] FOREIGN KEY([MaDH])
REFERENCES [dbo].[DonHang] ([MaDH])
GO
ALTER TABLE [dbo].[VCDH] CHECK CONSTRAINT [FK_VCDH_DonHang]
GO
ALTER TABLE [dbo].[VCDH]  WITH CHECK ADD  CONSTRAINT [FK_VCDH_PTVC] FOREIGN KEY([MaPTVC])
REFERENCES [dbo].[PTVC] ([MaPTVC])
GO
ALTER TABLE [dbo].[VCDH] CHECK CONSTRAINT [FK_VCDH_PTVC]
GO
