USE [QLCuaHangThucPham]
GO
/****** Object:  Table [dbo].[AnhSP]    Script Date: 3/29/2022 10:47:22 AM ******/
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
/****** Object:  Table [dbo].[CTDH]    Script Date: 3/29/2022 10:47:22 AM ******/
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
/****** Object:  Table [dbo].[DonHang]    Script Date: 3/29/2022 10:47:22 AM ******/
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
/****** Object:  Table [dbo].[GiaSP]    Script Date: 3/29/2022 10:47:22 AM ******/
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
/****** Object:  Table [dbo].[KhachHang]    Script Date: 3/29/2022 10:47:22 AM ******/
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
/****** Object:  Table [dbo].[LoaiSP]    Script Date: 3/29/2022 10:47:22 AM ******/
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
/****** Object:  Table [dbo].[LoaiTT]    Script Date: 3/29/2022 10:47:22 AM ******/
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
/****** Object:  Table [dbo].[PTTT]    Script Date: 3/29/2022 10:47:22 AM ******/
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
/****** Object:  Table [dbo].[PTVC]    Script Date: 3/29/2022 10:47:22 AM ******/
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
/****** Object:  Table [dbo].[SanPham]    Script Date: 3/29/2022 10:47:22 AM ******/
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
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 3/29/2022 10:47:22 AM ******/
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
/****** Object:  Table [dbo].[TinTuc]    Script Date: 3/29/2022 10:47:22 AM ******/
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
/****** Object:  Table [dbo].[TTDH]    Script Date: 3/29/2022 10:47:22 AM ******/
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
/****** Object:  Table [dbo].[VCDH]    Script Date: 3/29/2022 10:47:22 AM ******/
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
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A01', N'SP001', NULL, N'raungot.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A02', N'SP002', NULL, N'carot.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A03', N'SP003', NULL, N'bingo.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A04', N'SP004', NULL, N'bapcai.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A05', N'SP005', NULL, N'rauchanvit.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A06', N'SP006', NULL, N'suplo.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A07', N'SP007', NULL, N'khoailang.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A08', N'SP008', NULL, N'khoaitay.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A09', N'SP009', NULL, N'otngot.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A10', N'SP010', NULL, N'caixanh.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A11', N'SP011', NULL, N'raudiepca.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A12', N'SP012', NULL, N'bixanh.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A13', N'SP013', NULL, N'cachua.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A14', N'SP014', NULL, N'toi.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A15', N'SP015', NULL, N'cuden.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A16', N'SP016', NULL, N'saurieng.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A17', N'SP017', NULL, N'mit.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A18', N'SP018', NULL, N'cam.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A19', N'SP019', NULL, N'quyt.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A20', N'SP020', NULL, N'vaithieu.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A21', N'SP021', NULL, N'thanhlong.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A22', N'SP022', NULL, N'chuoi.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A23', N'SP023', NULL, N'hongxiem.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A24', N'SP024', NULL, N'duahau.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A25', N'SP025', NULL, N'vusua.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A26', N'SP026', NULL, N'tao.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A27', N'SP027', NULL, N'chanhday.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A28', N'SP028', NULL, N'dao.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A29', N'SP029', NULL, N'nho.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A30', N'SP030', NULL, N'luu.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A31', N'SP031', NULL, N'xoai.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A32', N'SP032', NULL, N'buoi.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A33', N'SP033', NULL, N'man.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A34', N'SP034', NULL, N'le.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A35', N'SP035', NULL, N'dudu.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A36', N'SP036', NULL, N'dautay.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A37', N'SP037', NULL, N'cocacola.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A38', N'SP038', NULL, N'traolong.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A39', N'SP039', NULL, N'caphesuabirdy.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A40', N'SP040', NULL, N'trabidao.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A41', N'SP041', NULL, N'biaheineken.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A42', N'SP042', NULL, N'tradaovahatchiafuzetea.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A43', N'SP043', NULL, N'caphedenhighlandscoffee.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A44', N'SP044', NULL, N'pepsi.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A45', N'SP045', NULL, N'7up.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A46', N'SP046', NULL, N'sprite.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A47', N'SP047', NULL, N'fanta.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A48', N'SP048', NULL, N'mirinda.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A49', N'SP049', NULL, N'nuoctao.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A50', N'SP050', NULL, N'bia333.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A51', N'SP051', NULL, N'biahanoi.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A52', N'SP052', NULL, N'nuoccamep.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A53', N'SP053', NULL, N'nutiboost.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A54', N'SP054', NULL, N'sting.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A55', N'SP055', NULL, N'lavi.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A56', N'SP056', NULL, N'ice+dao.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A57', N'SP057', NULL, N'ice+cam.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A58', N'SP058', NULL, N'teppy.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A59', N'SP059', NULL, N'c2.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A60', N'SP060', NULL, N'aquarius.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A61', N'SP061', NULL, N'toyen.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A62', N'SP062', NULL, N'strongbow.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A63', N'SP063', NULL, N'nescafe.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A64', N'SP064', NULL, N'g7.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A65', N'SP065', NULL, N'kokomi.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A66', N'SP066', NULL, N'omaichiboham.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A67', N'SP067', NULL, N'omaichisuonham.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A68', N'SP068', NULL, N'cornflake.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A69', N'SP069', NULL, N'kokokrucnh.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A70', N'SP070', NULL, N'Milo.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A71', N'SP071', NULL, N'oatta.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A72', N'SP072', NULL, N'bakalland.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A73', N'SP073', NULL, N'nhatbaominh.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A74', N'SP074', NULL, N'nepcaihoavang.jpg')
INSERT [dbo].[AnhSP] ([MaAnh], [MaSP], [TenAnh], [URL]) VALUES (N'A75', N'SP075', NULL, N'st25.jpg')
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G001', N'SP001', 20000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G002', N'SP002', 25900.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G003', N'SP003', 7000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G004', N'SP004', 22000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G005', N'SP005', 20000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G006', N'SP006', 40000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G007', N'SP007', 13000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G008', N'SP008', 40000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G009', N'SP009', 18000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G010', N'SP010', 20000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G011', N'SP011', 10000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G012', N'SP012', 7000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G013', N'SP013', 42000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G014', N'SP014', 60000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G015', N'SP015', 29000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G016', N'SP016', 80000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G017', N'SP017', 23000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G018', N'SP018', 20000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G019', N'SP019', 10000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G020', N'SP020', 35000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G021', N'SP021', 5000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G022', N'SP022', 10000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G023', N'SP023', 37000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G024', N'SP024', 20000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G025', N'SP025', 15000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G026', N'SP026', 20000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G027', N'SP027', 30000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G028', N'SP028', 20000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G029', N'SP029', 32000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G030', N'SP030', 20000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G031', N'SP031', 16000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G032', N'SP032', 45000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G033', N'SP033', 20000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G034', N'SP034', 40000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G035', N'SP035', 12000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G036', N'SP036', 160000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G037', N'SP037', 15000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G038', N'SP038', 9000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G039', N'SP039', 10000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G040', N'SP040', 7500.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G041', N'SP041', 19000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G042', N'SP042', 8600.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G043', N'SP043', 10000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G044', N'SP044', 16000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G045', N'SP045', 16000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G046', N'SP046', 20000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G047', N'SP047', 20000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G048', N'SP048', 17000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G049', N'SP049', 37500.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G050', N'SP050', 12000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G051', N'SP051', 11000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G052', N'SP052', 10000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G053', N'SP053', 28000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G054', N'SP054', 10000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G055', N'SP055', 5000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G056', N'SP056', 8000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G057', N'SP057', 8000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G058', N'SP058', 22000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G059', N'SP059', 9000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G060', N'SP060', 6000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G061', N'SP061', 10000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G062', N'SP062', 20000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G063', N'SP063', 55000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G064', N'SP064', 50000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G065', N'SP065', 3000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G066', N'SP066', 9000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G067', N'SP067', 9000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G068', N'SP068', 64000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G069', N'SP069', 49000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G070', N'SP070', 54000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G071', N'SP071', 89000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G072', N'SP072', 95000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G073', N'SP073', 168000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G074', N'SP074', 32000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[GiaSP] ([MaGia], [MaSP], [Gia], [Time_Begin], [Time_End]) VALUES (N'G075', N'SP075', 150000.0000, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL)
INSERT [dbo].[LoaiSP] ([MaLoai], [TenLoai], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'L01', N'Rau Củ', CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[LoaiSP] ([MaLoai], [TenLoai], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'L02', N'Trái cây', CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[LoaiSP] ([MaLoai], [TenLoai], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'L03', N'Đồ Uống', CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[LoaiSP] ([MaLoai], [TenLoai], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'L04', N'Đồ Khô', CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP001', N'Rau ngót', NULL, N'L01', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP002', N'Cà rốt', NULL, N'L01', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP003', N'Bí Ngô', NULL, N'L01', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP004', N'Bắp Cải', NULL, N'L01', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP005', N'Rau Chân Vịt', NULL, N'L01', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP006', N'Súp Lơ', NULL, N'L01', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP007', N'Khoai Lang', NULL, N'L01', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP008', N'Khoai Tây', NULL, N'L01', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP009', N'Ớt Ngọt', NULL, N'L01', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP010', N'Cải Xanh', NULL, N'L01', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP011', N'Rau Diếp Cá', NULL, N'L01', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP012', N'Bí Xanh', NULL, N'L01', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP013', N'Cà Chua', NULL, N'L01', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP014', N'Tỏi', NULL, N'L01', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP015', N'Củ dền', NULL, N'L01', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP016', N'Sầu Riêng', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP017', N'Mít', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP018', N'Cam', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP019', N'Quýt', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP020', N'Vải Thiều', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP021', N'Thanh Long', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP022', N'Chuối', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP023', N'Hồng Xiêm', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP024', N'Dưa Hấu', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP025', N'Vú Sữa', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP026', N'Táo', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP027', N'Chanh Dây', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP028', N'Đào', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP029', N'Nho', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP030', N'Lựu', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP031', N'Xoài', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP032', N'Bưởi', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP033', N'Mận', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP034', N'Lê', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP035', N'Đu Đủ', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP036', N'Dâu Tây', NULL, N'L02', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP037', N'CoCa Cola', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP038', N'Trà ô long  Tea+ ', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP039', N'Cà phê sữa Birdy', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP040', N'Trà bí đao', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP041', N'Bia Heineken', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP042', N'Trà Đào và hạt chia Fuzetea', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP043', N'Cà phê đen Highlands Coffee', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP044', N'Pepsi', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP045', N'7 Up', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP046', N'Sprite', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP047', N'Fanta', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP048', N'Mirinda', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP049', N'Nước Táo', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP050', N'Bia 333', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP051', N'Bia Hà Nội', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP052', N'Nước ép cam Twister Tropicana', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP053', N'Sữa trái cây hương dâu Nuti Boost', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP054', N'Nước tăng lực Sting hương dâu', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP055', N'Nước khoáng thiên nhiên Lavi', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP056', N'Nước trái cây Ice+ vị đào', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP057', N'Nước trái cây Ice+ vị cam', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP058', N'Nước cam ép có tép Teppy ', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP059', N'Trà chanh C2 hương chanh', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP060', N'Nước uống thể thao Aquarius', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP061', N'Tổ Yến', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP062', N'Nước táo lên men Strongbow', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP063', N'Cà Phê hòa tan Nescafé', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP064', N'Cà phê hòa tan G7', NULL, N'L03', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP065', N'Mì Kokomi Đại 90 Tôm chua cay', NULL, N'L04', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP066', N'Mì Omaichi Special bò hầm sốt vang', NULL, N'L04', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP067', N'Mò Omaichi vị sườn hầm ngũ quả thịt', NULL, N'L04', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP068', N'Ngũ cốc ăn sáng Corn Flakes Netslé', NULL, N'L04', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP069', N'Ngũ cốc ăn sáng Koko Krunch Nestlé', NULL, N'L04', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP070', N'Ngũ cốc ăn sáng Milo', NULL, N'L04', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP071', N'Yến mạch Oatta Trái cây', NULL, N'L04', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP072', N'Ngũ Cốc Bakalland Muesli 5 Dried Fruits & Honey', NULL, N'L04', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP073', N'Gạo giống Nhật Bảo Minh ', NULL, N'L04', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP074', N'Gạo nếp cái hoa vàng Phú Hải', NULL, N'L04', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [GTSP], [MaLoai], [SL], [Time_Create], [Time_Update], [NguoiTao], [isActive], [isDelete]) VALUES (N'SP075', N'Gạo ST25 Ngọc Nương', NULL, N'L04', 30, CAST(N'2022-03-26 17:51:00.000' AS DateTime), NULL, NULL, 1, 0)
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
USE [master]
GO
ALTER DATABASE [QLCuaHangThucPham] SET  READ_WRITE 
GO
