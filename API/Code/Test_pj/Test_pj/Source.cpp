#include<Windows.h>
LRESULT CALLBACK XuLyThongDiep(HWND hwnd, UINT msg, WPARAM wParam, LPARAM lParam) {
	switch (msg) {
	case WM_DESTROY:
		PostQuitMessage(0);
		break;
	default:
		break;
	}
	return DefWindowProc(hwnd, msg, wParam, lParam);
}
int WINAPI WinMain(HINSTANCE hInt, HINSTANCE preHint, PSTR cmdLine, int nshow) {
	WNDCLASS wndClass;
	static TCHAR name[] = TEXT("Example 1");
	wndClass.style = CS_HREDRAW | CS_VREDRAW;
	wndClass.lpfnWndProc = XuLyThongDiep;
	wndClass.cbClsExtra = 0;
	wndClass.cbWndExtra = 0;
	wndClass.hInstance = hInt;
	wndClass.hIcon = LoadIcon(hInt, name);
	wndClass.hCursor = LoadCursor(NULL, IDC_HAND);
	wndClass.hbrBackground = (HBRUSH)GetStockObject(WHITE_BRUSH);
	wndClass.lpszMenuName = NULL;
	wndClass.lpszClassName = name;
	if (!RegisterClass(&wndClass)) {
		MessageBox(NULL, TEXT("ERROR"), TEXT("MB"), MB_OK | MB_ICONERROR);
		return 0;
	}
	HWND hwnd = CreateWindow(name, TEXT("The first program!"), WS_OVERLAPPEDWINDOW, CW_USEDEFAULT, CW_USEDEFAULT, 1000, 500, NULL, NULL, hInt, NULL);
	ShowWindow(hwnd, nshow);
	UpdateWindow(hwnd);
	MSG msg;
	while (GetMessage(&msg, NULL, 0, 0)) {
		TranslateMessage(&msg);
		DispatchMessage(&msg);
	}
	return 0;
}
